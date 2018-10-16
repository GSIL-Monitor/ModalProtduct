package com.huimin.util;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SHA256Verify {
	public static Boolean verifyRequest(HttpServletRequest request, String secretKey) {
		Map<String, String> parames = getRequestMap(request);
		return verifyRequest(parames, secretKey);
	}

	public static Boolean verifyRequest(Map<String, String> parames, String secretKey) {
		if (!isHaveCtimeAndNounce(parames).booleanValue()) {
			logger.debug("result:fail. ctime, nonce, sign some of them value can *not* be empty.");
			return Boolean.valueOf(false);
		}
		logger.debug("result:ok. ctime, nonce, sign validated.");
		String sign = (String) parames.get("sign");
		parames.remove("sign");
		String serverSign = shuffAndSha256(parames, secretKey);
		if (serverSign.equals(sign)) {
			logger.info("Sha256 sign same. severSign use ASCII sort");
			return Boolean.valueOf(true);
		}
		String serverSignUseChinaSort = shuffAndSha256UseChinaSort(parames, secretKey);
		if (serverSignUseChinaSort.equals(sign)) {
			logger.info("Sha256 sign same. serverSign use China sort");
			return Boolean.valueOf(true);
		} else {
			logger.warn((new StringBuilder()).append("Sha256 sign *not* same.  ,severSignUseASCIISort:")
					.append(serverSign).append(" ,serverSignUseChinaSort:").append(serverSignUseChinaSort)
					.append(" ,request sign:").append(sign).toString());
			return Boolean.valueOf(false);
		}
	}

	public static String genSha256Sign(Map<String, String> parames, String secretKey) {
		return shuffAndSha256UseChinaSort(parames, secretKey);
	}

	public static Map<String, String> genSha256SignMap(Map<String, String> parames, String secretKey) {
		parames.put("sign", shuffAndSha256(parames, secretKey));
		return parames;
	}

	private static String shuffAndSha256(Map<String, String> requestMap, String secretKey) {
		String values = shuff(requestMap, secretKey);
		return new String(DigestUtils.sha256Hex(values.getBytes()));
	}

	private static String shuffAndSha256UseChinaSort(Map<String, String> requestMap, String secretKey) {
		String values = shuffUseChinaSort(requestMap, secretKey);
		return new String(DigestUtils.sha256Hex(values.getBytes()));
	}

	protected static String shuff(Map<String, String> requestMap, String secretKey) {
		String values = "";
		List<String> valueList = new ArrayList<>();
		java.util.Map.Entry<String, String> entry;
		for (Iterator<Entry<String, String>> iterator = requestMap.entrySet().iterator(); iterator.hasNext(); valueList.add(entry.getValue()))
			entry = (java.util.Map.Entry<String, String>) iterator.next();

		valueList.add(secretKey);
		Collections.sort(valueList);
		if (logger.isDebugEnabled()) {
			logger.debug("sort use ASCII:");
			String s;
			for (Iterator<String> iterator1 = valueList.iterator(); iterator1.hasNext(); logger.debug(s))
				s = (String) iterator1.next();

		}
		for (Iterator<String> iterator2 = valueList.iterator(); iterator2.hasNext();) {
			String s = (String) iterator2.next();
			values = (new StringBuilder()).append(values).append(s).toString();
		}

		logger.debug((new StringBuilder()).append("sort use ASCII in one line:").append(values).append(" length:")
				.append(values.length()).toString());
		return values;
	}

	protected static String shuffUseChinaSort(Map<String, String> requestMap, String secretKey) {
		String values = "";
		List<String> enValuesList = new ArrayList<>();
		List<String> chValuesList = new ArrayList<>();
		for (Iterator<Entry<String, String>> iterator = requestMap.entrySet().iterator(); iterator.hasNext();) {
			java.util.Map.Entry<String, String> entry = (java.util.Map.Entry<String, String>) iterator.next();
			String value =  entry.getValue();
			if (isStartWithChinese(value))
				chValuesList.add(value);
			else
				enValuesList.add(value);
		}

		enValuesList.add(secretKey);
		Collections.sort(enValuesList);
		Collections.sort(chValuesList, comparator);
		if (logger.isDebugEnabled()) {
			logger.debug("sort use china:");
			String s;
			for (Iterator<String> iterator1 = enValuesList.iterator(); iterator1.hasNext(); logger.debug(s))
				s = (String) iterator1.next();

			for (Iterator<String> iterator2 = chValuesList.iterator(); iterator2.hasNext(); logger.debug(s))
				s = (String) iterator2.next();

		}
		for (Iterator<String> iterator3 = enValuesList.iterator(); iterator3.hasNext();) {
			String s = (String) iterator3.next();
			values = (new StringBuilder()).append(values).append(s).toString();
		}

		for (Iterator<String> iterator4 = chValuesList.iterator(); iterator4.hasNext();) {
			String s = (String) iterator4.next();
			values = (new StringBuilder()).append(values).append(s).toString();
		}

		logger.debug((new StringBuilder()).append("sort use china in one line:").append(values).append(" length:")
				.append(values.length()).toString());
		return values;
	}

	private static Boolean isHaveCtimeAndNounce(Map<String, String> parames) {
		String ctime = parames.get("ctime");
		String nonce = parames.get("nonce");
		String sign = parames.get("sign");
		return StringUtils.isNotEmpty(ctime) && StringUtils.isNotEmpty(nonce) && StringUtils.isNotEmpty(sign);
	}

	protected static boolean isStartWithChinese(String word) {
		Pattern r = Pattern.compile(startWithChinesePattern);
		Matcher matcher = r.matcher(word);
		return matcher.find();
	}

	private static final String startWithChinesePattern = "^[\u4E00-\u9FA5]";
	private static Logger logger = LoggerFactory.getLogger(SHA256Verify.class);
	private static Comparator<Object> comparator;

	static {
		comparator = Collator.getInstance(Locale.CHINA);
	}

	public static Map<String, String> getRequestMap(HttpServletRequest request) {
		Map<String, String> requestParames = new HashMap<>();
		if (null != request) {
			Set<String> keys = request.getParameterMap().keySet();
			String key;
			for (Iterator<String> iterator = keys.iterator(); iterator.hasNext(); requestParames.put(key,
					request.getParameter(key)))
				key = (String) iterator.next();

		}
		return requestParames;
	}
}

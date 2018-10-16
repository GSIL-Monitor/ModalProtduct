package com.huimin.util;

import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;


public class Sha256SignUtil {
	public static Map<String, String> sign(Map<String, String> requestParames, String secretKey)
    {
        requestParames.put("ctime", (new StringBuilder()).append(System.currentTimeMillis()).append("").toString());
        requestParames.put("nonce", RandomStringUtils.randomAlphanumeric(20));
        return SHA256Verify.genSha256SignMap(requestParames, secretKey);
    }
}

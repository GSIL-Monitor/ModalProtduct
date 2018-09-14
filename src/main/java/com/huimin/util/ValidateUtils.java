package com.huimin.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.http.conn.util.InetAddressUtils;

/**
 * 验证工具类
 * 
 * 作者: zhoubang 日期：2015年3月26日 下午1:35:46
 */
public class ValidateUtils {

    private static transient final String REGEX_IS_CHINESE = "^[\\u4e00-\\u9fa5][\\u4e00-\\u9fa5]*[\\u4e00-\\u9fa5]$";
    private static transient final String REGEX_IS_EMAIL = "^([a-z0-9A-Z]+[-_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 是否email
     *
     * @param email
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isEmail(String email) {
        return isMatch(email, REGEX_IS_EMAIL);
    }

    /**
     * 是否email
     *
     * @param email
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isNotEmail(String email) {
        return !isEmail(email);
    }

    /**
     * 是否ipv4
     *
     * @param ipv4
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isIPv4(String ipv4) {
        return InetAddressUtils.isIPv4Address(ipv4);
    }

    /**
     * 是否ipv4
     *
     * @param ipv4
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isNotIPv4(String ipv4) {
        return !isIPv4(ipv4);
    }

    /**
     * 是否ipv6
     *
     * @param ipv6
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isIPv6(String ipv6) {
        return InetAddressUtils.isIPv6Address(ipv6);
    }

    /**
     * 是否ipv6
     *
     * @param ipv6
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isNotIPv6(String ipv6) {
        return !isIPv6(ipv6);
    }

    /**
     * 是否中文
     *
     * @param str
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isChinese(String str) {
        return isMatch(str, REGEX_IS_CHINESE);
    }

    /**
     * 是否数字
     *
     * @param str
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isNumeric(String str) {
        return StringUtils.isNumeric(str);
    }

    /**
     * 是否数字
     *
     * @param str
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isNotNumeric(String str) {
        return !isNumeric(str);
    }

    /**
     * 正则表达式验证
     *
     * @param str
     *            a {@link java.lang.String} object.
     * @param regex
     *            a {@link java.lang.String} object.
     * @return 验证结果
     */
    public static boolean isMatch(String str, String regex) {
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        return true;
    }

}

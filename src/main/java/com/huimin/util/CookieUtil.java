package com.huimin.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * 作者: zhoubang 日期：2015年3月26日 下午1:33:02
 */
public class CookieUtil {

    private CookieUtil() {
    }

    /**
     * 添加cookie
     * 
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void addCookie(HttpServletResponse response, String name,
            String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * 删除cookie
     * 
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletResponse response, String name) {
        Cookie uid = new Cookie(name, null);
        uid.setPath("/");
        uid.setMaxAge(0);
        response.addCookie(uid);
    }

    /**
     * 获取cookie值
     * 
     * @param request
     * @return
     */
    public static String getUid(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("U")) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
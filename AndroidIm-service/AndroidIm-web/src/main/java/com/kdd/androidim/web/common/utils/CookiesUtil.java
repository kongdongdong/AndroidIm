package com.kdd.androidim.web.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kdd on 17/9/2.
 */
public class CookiesUtil {

    public static String addCookies(HttpServletResponse response){
        String uuid  = UUIDUtil.getUUIDStr();
        Cookie cookie = new Cookie("sid",uuid);   // 新建Cookie
        cookie.setMaxAge(120);           // 设置生命周期为MAX_VALUE
        cookie.setPath("/");
        response.addCookie(cookie);
        return uuid;
    }

}

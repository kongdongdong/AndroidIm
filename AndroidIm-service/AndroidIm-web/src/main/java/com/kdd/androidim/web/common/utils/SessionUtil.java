package com.kdd.androidim.web.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kdd on 17/9/2.
 */
public class SessionUtil {

    private static Map<String,String> sessionMap = new HashMap<String, String>();

    public static void addSession(String username,String sid){
        sessionMap.put(username,sid);
    }

    public static boolean getSession(String sid){
        return sessionMap.containsValue(sid);
    }


}

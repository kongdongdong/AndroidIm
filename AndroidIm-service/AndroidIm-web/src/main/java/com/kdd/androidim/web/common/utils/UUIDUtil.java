package com.kdd.androidim.web.common.utils;

import java.util.UUID;

/**
 * Created by kdd on 17/9/2.
 */
public class UUIDUtil {

    public static String getUUIDStr(){
        return String.valueOf(UUID.randomUUID()).replace("-","");
    }

}

package com.kdd.androidim.web.common.domain;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * Created by kdd on 17/8/31.
 */
public class BaseBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}

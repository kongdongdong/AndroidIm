package com.kdd.androidim.web.common.domain;

import com.kdd.androidim.web.common.enums.ResultCode;
import com.kdd.androidim.web.common.exception.IException;

/**
 * Created by kdd on 17/9/1.
 */
public class BaseResponse<T> extends BaseBean implements IException {


    private static final long serialVersionUID = 1L;

    private Integer code;

    private String desc;

    private Integer status;

    private String userMsg;

    private String url;

    private T data;

    public BaseResponse(Integer code, String desc, Integer status, String userMsg) {
        this.code = code;
        this.desc = desc;
        this.status = status;
        this.userMsg = userMsg;
    }

    public BaseResponse(ResultCode resultCode, Integer status, String userMsg) {
        this(resultCode.getCode(),resultCode.getMsg(),status,userMsg);
    }

    public BaseResponse(Integer status, String userMsg) {
        this(ResultCode.Result_SUCCESS.getCode(),ResultCode.Result_SUCCESS.getMsg(),status,userMsg);
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUserMsg(String userMsg) {
        this.userMsg = userMsg;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public T getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getUserMsg() {
        return userMsg;
    }
}

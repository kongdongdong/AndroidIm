package com.kdd.androidim.web.common.exception;


import com.kdd.androidim.web.common.enums.ResultCode;

public class BizException extends RuntimeException implements IException {
	private static final long serialVersionUID = 1L;

	private Integer code;
	
	private String desc;
	
	private Integer status;
	
	private String userMsg;
	
	public BizException(IException bizExcep) {
		this(bizExcep.getCode(), bizExcep.getDesc(), bizExcep.getStatus(), bizExcep.getUserMsg());
	}
	
	public BizException(ResultCode resultCode, Integer subCode, String subMessage) {
		this(resultCode.getCode(), resultCode.getMsg(), subCode, subMessage);
	}
	
	public BizException(Integer code, String desc, Integer status, String userMsg) {
		super(userMsg);
		this.code = code;
		this.desc = desc;
		this.status = status;
		this.userMsg = userMsg;
	}
	
	public static void warn(String subMessage) {
		throw new BizException(ResultCode.Result_WARN, ResultCode.Result_WARN.getCode(), subMessage);
	}

	public static void warn(Integer subCode, String subMessage) {
		throw new BizException(ResultCode.Result_WARN, subCode, subMessage);
	}

	public static void warn501(Integer subCode, String subMessage) {
		throw new BizException(ResultCode.Result_501, subCode, subMessage);
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

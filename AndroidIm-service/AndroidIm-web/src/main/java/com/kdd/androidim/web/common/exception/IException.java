package com.kdd.androidim.web.common.exception;

public interface IException {
	
	Integer getCode();

	String getDesc();
	
	Integer getStatus();
	
	String getUserMsg();
}

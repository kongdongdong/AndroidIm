package com.kdd.androidim.web.common.exception;


import com.kdd.androidim.web.common.domain.BaseResponse;
import com.kdd.androidim.web.common.enums.ResultCode;

public class ExceptionHelper {
	

	public static <T> BaseResponse<T> createResponse(Throwable e){
		if (e instanceof IException) {
			IException ex = (IException) e;
			return new BaseResponse<T>(ex.getCode(), ex.getDesc(), ex.getStatus(), ex.getUserMsg());
		}else {
			return new BaseResponse<T>(ResultCode.Result_ERROR,0,"");
		}
	}
	

}

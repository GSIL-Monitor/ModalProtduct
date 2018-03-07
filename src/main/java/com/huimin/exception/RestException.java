package com.huimin.exception;

import com.huimin.enun.ResultEnum;

/**
 * 
 * @author zhuliang
 *
 * @date 2018年1月7日
 */
public class RestException extends RuntimeException {

    
	private static final long serialVersionUID = 1L;
	private ResultEnum code;
    private String errorMessage;

    public RestException() {
        super(ResultEnum.ERROR.getMessage());
        this.code = ResultEnum.ERROR;
        this.errorMessage = ResultEnum.ERROR.getMessage();
    }

    public RestException(ResultEnum code) {
        super(code.getMessage());
        this.code = code;
        this.errorMessage = code.getMessage();
    }

    public RestException(ResultEnum code, String message) {
        super(message);
        this.code = code;
        this.errorMessage = message;
    }

    public ResultEnum getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

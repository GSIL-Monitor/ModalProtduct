package com.huimin.result.handler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.huimin.result.Result;
import com.huimin.result.enums.GlobalResultCode;
import com.huimin.result.exception.BusinessException;
import com.huimin.util.LogUtil;



/**
 * 统一异常处理器
 * @author Admin
 *
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler{

	private LogUtil logger = LogUtil.logger(GlobalExceptionHandler.class);
    /**
	 * 违反数据库主键约束异常，例如主键长度约束、字符约束等
	 */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e);
    	return Result.newInstance().setResultCode(GlobalResultCode.PARAM_IS_BLANK);
    }
    
    /**
   	 * 未知异常处理
   	 */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
    	logger.error(e);
    	return Result.newInstance().setResultCode(GlobalResultCode.ERROR);
    }
    
    /**
   	 * 业务异常处理
   	 */
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
    	logger.error(e);
    	return Result.newInstance().setBusinessException(e);
    }
}


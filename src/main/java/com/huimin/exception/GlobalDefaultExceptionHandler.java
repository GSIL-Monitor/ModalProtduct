package com.huimin.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huimin.commen.Response;
import com.huimin.enun.ResultEnum;

/**
 * 
 * @author zhuliang
 *
 * @date 2018年1月7日
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	private final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

	/**
	 * 
	 * @param request
	 * @param cmsException  统一处理cms异常
	 * @return
	 */
	@ExceptionHandler(value = RestException.class)
	@ResponseBody
	public Response cmsExceptionHandler(HttpServletRequest request, RestException cmsException) {
		logger.error(joinErrorMessage(request), cmsException);
		return Response.error(cmsException).build();
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Response handleException(HttpServletRequest request,IllegalArgumentException ex) {
		logger.error(joinErrorMessage(request), ex);
		Response.ResponseBuilder resp = Response.error();
        if (StringUtils.isNotBlank(ex.getMessage())) {
            resp.setMessage(ex.getMessage());
        }
        return resp.build();
    }
    /**
     * 统一处理exception
     *
     * @param request
     * @param exception
     * @return 自定义返回对象
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response exceptionHandler(HttpServletRequest request, Exception exception) {
		logger.error(joinErrorMessage(request), exception);
        return Response.error().build();
    }


    /**
     * 统一处理400
     *
     * @param request
     * @param exception
     * @return 自定义返回对象
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public Response excHandler(HttpServletRequest request, Exception exception) {
        logger.error(joinErrorMessage(request), exception);
        return Response.error(ResultEnum.BAD_REQUEST).setMessage(exception.getMessage()).build();
    }

    /**
     * 组织具体异常源
     * url : 请求路径
     * method: 请求方式
     * ip : 请求来源
     *
     * @param request httpRequest
     * @return 具体异常源
     */
    private String joinErrorMessage(HttpServletRequest request) {
        return new StringBuilder("url : " + request.getRequestURL().toString() + ", ")
                .append("method : " + request.getMethod()).toString();
    }
}

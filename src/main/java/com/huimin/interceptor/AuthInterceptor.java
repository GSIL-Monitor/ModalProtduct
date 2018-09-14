package com.huimin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//HandlerMethod handlerMethod = (HandlerMethod) handler;
//		Map<String, String[]> parameterMap = request.getParameterMap();
//		System.out.println(parameterMap);
//		String contentType = request.getContentType();
//		System.out.println(contentType);
//		System.out.println("我是权限拦截器");
//		ServletInputStream inputStream = request.getInputStream();
//		byte[] bytes = new byte[request.getContentLength()];
//		inputStream.read(bytes);
//		String string = new String(bytes);
//		System.out.println(string);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}

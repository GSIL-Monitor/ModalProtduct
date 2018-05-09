package com.huimin.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.huimin.enun.User;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(User.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		User user = parameter.getParameterAnnotation(User.class);
		String parameterName = parameter.getParameterName();
		String parame = webRequest.getParameter(parameterName);
		String name = user.name();
		System.out.println(parame);
		System.out.println(name);
		return parame;
	}

}

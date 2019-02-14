package com.huimin.init;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
         applicationContext = context;		
	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}
	public static <T> T getBean(String name, Class<T> clazz) {
		return  applicationContext.getBean(name, clazz);
	}
}

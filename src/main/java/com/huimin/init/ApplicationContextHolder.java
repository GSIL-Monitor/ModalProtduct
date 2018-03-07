package com.huimin.init;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         this.applicationContext = applicationContext;		
	}
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	
	public <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}
	public <T> T getBean(String name, Class<T> clazz) {
		return  applicationContext.getBean(name, clazz);
	}
}

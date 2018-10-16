package com.huimin.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.huimin.entity.Student;

public class DynamicBeanRegistry implements ImportBeanDefinitionRegistrar{
		  
	    protected String[] BEAN_NAME = {"student10", "student11"};  

		@Override
		public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
				BeanDefinitionRegistry registry) {
			for (String name : BEAN_NAME) {
				GenericBeanDefinition beanDefinition = new GenericBeanDefinition();  
				beanDefinition.setBeanClass(Student.class);  
				beanDefinition.setSynthetic(true);
				beanDefinition.setAutowireMode(1);
				MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
				propertyValues.add("name", name);
				beanDefinition.setAttribute("name", name);
				registry.registerBeanDefinition(name, beanDefinition);  
			}
		}
}

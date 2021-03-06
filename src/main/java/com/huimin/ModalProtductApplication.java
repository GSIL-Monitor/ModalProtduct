package com.huimin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.alibaba.fastjson.JSON;
import com.huimin.config.DynamicBeanRegistry;


@SpringBootApplication
//@MapperScan(basePackages = "com.huimin.mapper")
//@EnableDiscoveryClient
@Import(DynamicBeanRegistry.class)
//@EnableDubbo
public class ModalProtductApplication {

	public static void main(String[] args) {
		//System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\myself\\jar\\cjlb\\springcglibJar2");
		SpringApplication.run(ModalProtductApplication.class, args);
		//FastJsonHttpMessageConverter设置dateFormat后导致JSONField注解format失效解决办法
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	}
}

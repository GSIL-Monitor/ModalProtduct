package com.huimin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.fastjson.JSON;


@SpringBootApplication
//@MapperScan(basePackages = "com.huimin.mapper")
//@EnableDiscoveryClient
public class ModalProtductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModalProtductApplication.class, args);
		//FastJsonHttpMessageConverter设置dateFormat后导致JSONField注解format失效解决办法
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	}
}

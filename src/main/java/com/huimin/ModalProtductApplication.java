package com.huimin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.huimin.mapper")
public class ModalProtductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModalProtductApplication.class, args);
	}
}

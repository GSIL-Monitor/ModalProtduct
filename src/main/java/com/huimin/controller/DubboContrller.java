package com.huimin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.zhuliang.facade.DemoFacade;

@RestController
@RequestMapping("hello")
public class DubboContrller {

	@Reference
	private DemoFacade demoFacade;
	@GetMapping("/sayHello")
	public String sayHello(String name) {
		return demoFacade.sayHello(name);
	}
}

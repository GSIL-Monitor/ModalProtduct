package com.huimin.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebLog {

	@Before("@annotation(org.springframework.web.bind.annotation.GetMapping) || " 
			+ "@annotation(org.springframework.web.bind.annotation.PostMapping) || "
			+ "@annotation(org.springframework.web.bind.annotation.PutMapping) ||" 
			+ "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||" 
			+ "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void doBefore(JoinPoint joinpoint) {
		System.out.println("我是切面  " + joinpoint.getSignature().getName());
	}
}

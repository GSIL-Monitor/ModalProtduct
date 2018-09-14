package com.huimin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huimin.commen.Response;
import com.huimin.result.annotation.ResultHandleNo;

@RestController
public class TestController {

	@PostMapping("/test")
	@ResultHandleNo
	public Response testContentType() {
		//System.out.println(student);
		return Response.ok().build();
	}
}

package com.huimin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huimin.commen.Response;
import com.huimin.rabbitmq.Sender;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

	@Autowired
	private Sender sender;
	@GetMapping("/send")
	public Response sendMessage(@RequestParam String msg) {
		sender.sendMessage(msg);
		return Response.ok().build();
	}
}

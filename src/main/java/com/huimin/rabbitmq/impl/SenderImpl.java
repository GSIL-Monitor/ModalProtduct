package com.huimin.rabbitmq.impl;

import java.util.UUID;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huimin.rabbitmq.Sender;
import com.huimin.util.LogUtil;
@Component
public class SenderImpl implements Sender{

	@Autowired
	private RabbitTemplate rabbitTemplate;
	private LogUtil logger = LogUtil.logger(SenderImpl.class);
	
	@Override
	public void sendMessage(String message) {
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		logger.info("satart send message : {}", message);
	    rabbitTemplate.convertAndSend("topicExchange", "key.1", message, correlationId);
	    logger.info("end send message : {}", message);
	   // logger.info("consumer response : {}", response);
	}

}

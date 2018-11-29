package com.huimin.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huimin.util.LogUtil;

@Component
public class SenderCallback implements RabbitTemplate.ConfirmCallback, ReturnCallback, InitializingBean {
	private LogUtil logger = LogUtil.logger(SenderCallback.class);
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Override
	public void returnedMessage(Message message, int arg1, String arg2, String arg3, String arg4) {
        logger.error(message.getMessageProperties().getCorrelationId() + " 发送失败");
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		if (ack) {
			logger.info("message send success, data: {}" , correlationData);
		}else {
			logger.info("message send falid, cause: {}" , cause);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		rabbitTemplate.setConfirmCallback(this);
		rabbitTemplate.setReturnCallback(this);		
	}

}

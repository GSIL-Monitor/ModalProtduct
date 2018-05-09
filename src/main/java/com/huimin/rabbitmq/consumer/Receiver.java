package com.huimin.rabbitmq.consumer;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class Receiver {

	@RabbitListener(queues = "hello.queue1")
	public void processMessage1(String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,  Channel channel) throws IOException {
		System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue1队列的消息：" + msg);
		channel.basicAck(deliveryTag, false);
	}
	@RabbitListener(queues = "hello.queue2")
	public void processMessage2(String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,  Channel channel) throws IOException {
		System.out.println(Thread.currentThread().getName() + " 接收到来自hello.queue2队列的消息：" + msg);
		channel.basicAck(deliveryTag, false);
	}


}

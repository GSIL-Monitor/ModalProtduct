package com.huimin.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	@Bean(name = "queue1", autowire = Autowire.BY_NAME)
	public Queue queue1() {
		return new Queue("hello.queue1", true);
	}

	@Bean(name = "queue2", autowire = Autowire.BY_NAME)
	public Queue queue2() {
		return new Queue("hello.queue2", true);
	}

	// 声明交互器
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("topicExchange");
	}

	// 绑定
	@Bean
	public Binding binding1() {
		return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1");
	}

	@Bean
	public Binding binding2() {
		return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
	}

}

package com.huimin.task;

import org.quartz.Scheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(){
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
		factoryBean.setStartupDelay(20);
		return factoryBean;
	}
	
	@Bean
	public Scheduler scheduler(){
		return schedulerFactoryBean().getScheduler();
	}
}

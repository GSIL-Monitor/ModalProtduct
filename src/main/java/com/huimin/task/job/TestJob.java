package com.huimin.task.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job{

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(jobExecutionContext.getMergedJobDataMap().get("group"));
        System.out.println(jobExecutionContext.getMergedJobDataMap().get("id"));
        
		System.out.println("我是石英定时任务");
		
		System.out.println(jobExecutionContext.get("group"));
		System.out.println(jobExecutionContext.get("id"));
	}

}

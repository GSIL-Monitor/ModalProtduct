package com.huimin.task.job;

import java.lang.reflect.Method;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huimin.init.ApplicationContextHolder;
public class CronJob implements Job{

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
		String className = jobDataMap.getString("className");
		String methodName = jobDataMap.getString("methodName");
		
		Object target = ApplicationContextHolder.getBean(className);
		try {
			Method method = target.getClass().getDeclaredMethod(methodName);
			method.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

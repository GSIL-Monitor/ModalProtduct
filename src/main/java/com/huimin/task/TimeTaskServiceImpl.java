package com.huimin.task;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.huimin.entity.Cron;
import com.huimin.result.exception.BusinessException;
import com.huimin.task.job.CronJob;

@Service
public class TimeTaskServiceImpl implements TimeTaskService {

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@Override
	public void startJob(Job job, String name, String group, Date stateTime) {
		JobDetail jobDetail = JobBuilder.newJob(job.getClass()).usingJobData("name", name).usingJobData("group", group)
				.withIdentity(name, group).build();
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).startAt(stateTime)
				.build();
		try {
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteJob(String name, String group) {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = new JobKey(name, group);
		try {
			return scheduler.deleteJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void startJobNow(Job job, String name, String group) {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail;
		try {
			JobKey jobKey = new JobKey(name, group);
			jobDetail = scheduler.getJobDetail(jobKey);
			if (jobDetail != null) {
				// 删除当前任务
				deleteJob(name, group);
			}
			// 启动时间设置为当前
			startJob(job, name, group, new Date());
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createCronJob(Cron cron) {
		try {
			JobDetail jobDetail = JobBuilder.newJob(CronJob.class).usingJobData("className", cron.getClassName()).usingJobData("methodName", cron.getMethodName())
					.withIdentity(cron.getJobKey()).build();
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			CronTriggerImpl cronTrigger = new CronTriggerImpl();
			cronTrigger.setCronExpression(cron.getCron());
			cronTrigger.setJobKey(new JobKey(cron.getJobKey()));
			cronTrigger.setKey(new TriggerKey(cron.getJobKey()));
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.start();
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		
	}

	@Override
	public JobDetail findJob(String name, String group) {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = new JobKey(name, group);
			try {
				return scheduler.getJobDetail(jobKey);
			} catch (SchedulerException e) {
				throw new RuntimeException(e);
			}
	}

}

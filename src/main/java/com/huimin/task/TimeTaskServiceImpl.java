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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class TimeTaskServiceImpl implements TimeTaskService {

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@Override
	public void startJob(Job job, String group, String id, Date stateTime) {
		JobDetail jobDetail = JobBuilder.newJob(job.getClass()).usingJobData("group", group).usingJobData("id", id)
				.withIdentity("group", group + "_" + id).build();
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("group", group + "_" + id).startAt(stateTime)
				.build();
		try {
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteJob(String group, String id) {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = new JobKey("group", group + "_" + id);
		try {
			return scheduler.deleteJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void startJobNow(Job job, String group, String id) {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail;
		try {
			JobKey jobKey = new JobKey("group", group + "_" + id);
			jobDetail = scheduler.getJobDetail(jobKey);
			if (jobDetail != null) {
				// 删除当前任务
				deleteJob(group, id);
			}
			// 启动时间设置为当前
			startJob(job, group, id, new Date());
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}

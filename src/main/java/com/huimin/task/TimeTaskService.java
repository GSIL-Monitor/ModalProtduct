package com.huimin.task;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;

import com.huimin.entity.Cron;

/**
 * 启动石英任务
 * @author zhuliang
 *
 * @date 2017年12月21日
 */
public interface TimeTaskService {

	public void startJob(Job job, String name, String group, Date stateTime);
	
	public void startJobNow(Job job, String name, String group);
	
	public boolean deleteJob(String name, String group);
	
	public void createCronJob(Cron cron);
	
	public JobDetail findJob(String name, String group);
}

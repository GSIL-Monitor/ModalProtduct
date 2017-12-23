package com.huimin.task;

import java.util.Date;

import org.quartz.Job;

/**
 * 启动石英任务
 * @author zhuliang
 *
 * @date 2017年12月21日
 */
public interface TimeTaskService {

	public void startJob(Job job, String group, String id, Date stateTime);
	
	public void startJobNow(Job job, String group, String id);
	
	public boolean deleteJob(String group, String id);
}

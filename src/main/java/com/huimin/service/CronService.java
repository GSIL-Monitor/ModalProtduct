package com.huimin.service;

import com.baomidou.mybatisplus.service.IService;
import com.huimin.entity.Cron;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuliang
 * @since 2019-02-13
 */
public interface CronService extends IService<Cron> {
	/**
	 * 创建石英定时任务
	 * @param cron
	 */
	void createCron(Cron cron);
	
	/**
	 * 删除石英定时任务
	 * @param jobKey
	 */
	void deleteCron(String jobKey);
	
	/**
	 * 停止石英定时任务
	 * @param jobKey
	 */
	void stopCron(String jobKey);
	
	/**
	 * 启动石英定时任务
	 * @param jobKey
	 */
	void startCron(String jobKey);
	
	/**
	 * 启动石英定时任务
	 * @param jobKey
	 */
	void updateCron(Cron cron);
	
	
	
}

package com.huimin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huimin.entity.Cron;
import com.huimin.service.CronService;

@RestController
@RequestMapping("/cron")
public class CronController {

	@Autowired
	private CronService cronService;
	@PostMapping("/create")
	public void createCron(Cron cron) {
		cronService.createCron(cron);
	}
	

	/**
	 * 删除石英定时任务
	 * @param jobKey
	 */
	@PostMapping("/delete")
	public void deleteCron(String jobKey) {
		cronService.deleteCron(jobKey);
	};
	
	/**
	 * 停止石英定时任务
	 * @param jobKey
	 */
	@PostMapping("/stop")
	public void stopCron(String jobKey) {
		cronService.stopCron(jobKey);
	};
	
	/**
	 * 启动石英定时任务
	 * @param jobKey
	 */
	@PostMapping("/start")
	public void startCron(String jobKey) {
		cronService.startCron(jobKey);
	};
	
	/**
	 * 启动石英定时任务
	 * @param jobKey
	 */
	@PostMapping("/updtae")
	void updateCron(Cron cron) {
		cronService.updateCron(cron);
	};
}

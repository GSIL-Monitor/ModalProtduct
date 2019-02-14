package com.huimin.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.huimin.entity.Cron;
import com.huimin.service.CronService;
import com.huimin.task.TimeTaskService;

/**
 * 项目启动时需要启动所有的定时任务
 * @author zhuliang
 *
 * @Date 2019年2月14日下午1:45:43
 */
@Component
public class CronStartupRunner implements CommandLineRunner{

	@Autowired
	private CronService cronService;
	
	@Autowired
	private TimeTaskService timeTaskService;
	@Override
	public void run(String... args) throws Exception {
		List<Cron> crons = cronService.selectList(null);
		for (Cron cron : crons) {
			timeTaskService.createCronJob(cron);
		}
	}

}

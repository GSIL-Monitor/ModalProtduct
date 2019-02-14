package com.huimin.component;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.huimin.util.DateUtil;

@Component("cronComponent")
public class CronComponent {

	public void testCron() {
		System.out.println(DateUtil.format(new Date()) + ":测试石英定时任务..........");
	}
}

package com.huimin.base;

import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.huimin.entity.Student;
import com.huimin.init.MyStartupRunner1;
import com.huimin.task.TimeTaskService;
import com.huimin.task.job.TestJob;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {

	@Autowired
	private TimeTaskService timeTaskService;
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	@Autowired
	private MyStartupRunner1 myStartupRunner1;
	@Test
	public void test02() throws SchedulerException{
		Map<Integer, Student> init = MyStartupRunner1.INIT;
		System.out.println(init);
		
		System.out.println(myStartupRunner1.get(1));
 	}
	@Test
	public void test01() throws SchedulerException{
		timeTaskService.startJob(new TestJob(), "test", "1", new Date(new Date().getTime() + 10000000000L));
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail = scheduler.getJobDetail(new JobKey("group", "test_1"));
		System.out.println(jobDetail);
		Trigger trigger = scheduler.getTrigger(new TriggerKey("group", "test_1"));
		System.out.println(trigger);
		System.out.println(trigger.getStartTime());
		System.out.println(trigger.getEndTime());
		timeTaskService.startJobNow(new TestJob(), "test", "1");
//		boolean success = timeTaskService.deleteJob("test", "1");
//		System.out.println(success);
//		JobDetail jobDetail2 = scheduler.getJobDetail(new JobKey("group", "test_1"));
//		System.out.println(jobDetail2);
//		Trigger trigger2 = scheduler.getTrigger(new TriggerKey("group", "test_1"));
//		System.out.println(trigger2);
	}
}

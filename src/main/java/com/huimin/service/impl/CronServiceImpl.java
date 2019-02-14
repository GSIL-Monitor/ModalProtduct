package com.huimin.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huimin.entity.Cron;
import com.huimin.mapper.CronMapper;
import com.huimin.service.CronService;
import com.huimin.task.TimeTaskService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuliang
 * @since 2019-02-13
 */
@Service
public class CronServiceImpl extends ServiceImpl<CronMapper, Cron> implements CronService {

	@Autowired
	private TimeTaskService timeTaskService;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void createCron(Cron cron) {
		String jobkey = UUID.randomUUID().toString().replace("-", "");
		cron.setJobKey(jobkey);
		baseMapper.insert(cron);
		timeTaskService.createCronJob(cron);
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteCron(String jobKey) {
		if (timeTaskService.deleteJob(jobKey, null)) {
			baseMapper.delete(new EntityWrapper<Cron>().eq(Cron.JOB_KEY, jobKey));
		}		
	}
	@Override
	public void stopCron(String jobKey) {
		timeTaskService.deleteJob(jobKey, null);
	}
	@Override
	public void startCron(String jobKey) {
		Cron entity = new Cron();
		entity.setJobKey(jobKey);
		Cron cron = baseMapper.selectOne(entity);
		if (cron != null) {
			timeTaskService.createCronJob(cron);
		}
		
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateCron(Cron cron) {
		baseMapper.updateById(cron);
		Cron selectById = baseMapper.selectById(cron.getId());
		timeTaskService.deleteJob(selectById.getJobKey(), null);
		timeTaskService.createCronJob(selectById);
	}
	
}

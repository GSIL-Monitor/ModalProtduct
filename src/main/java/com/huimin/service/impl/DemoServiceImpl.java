package com.huimin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huimin.config.routingdatasource.TargetDataSource;
import com.huimin.entity.Demo;
import com.huimin.mapper.DemoMapper;
import com.huimin.service.DemoService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuliang
 * @since 2018-09-27
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {
	@Override
	@TargetDataSource(name = "datasource3")
	public boolean insertBatch(List<Demo> entityList, int batchSize) {
		return super.insertBatch(entityList, batchSize);
	}
}

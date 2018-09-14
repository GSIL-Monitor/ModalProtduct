package com.huimin.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huimin.entity.MethodLock;
import com.huimin.mapper.MethodLockMapper;
import com.huimin.service.MethodLockService;

/**
 * <p>
 * 锁定中的方法 服务实现类
 * </p>
 *
 * @author zhuliang
 * @since 2018-07-10
 */
@Service
public class MethodLockServiceImpl extends ServiceImpl<MethodLockMapper, MethodLock> implements MethodLockService {

	@Override
	public boolean deleteByMethodAndUUid(String method, String uuid) {
		return delete(new EntityWrapper<MethodLock>()
				.eq(MethodLock.METHOD_NAME, method)
				.eq(MethodLock.UUID, uuid));
	}
	
}

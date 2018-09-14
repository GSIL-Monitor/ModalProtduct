package com.huimin.distributedlock;

import org.springframework.beans.factory.annotation.Autowired;

import com.huimin.entity.MethodLock;
import com.huimin.service.MethodLockService;
import com.huimin.util.LogUtil;

//@Service
public class MysqlDistributionLockImpl implements DistributionLock{
	private static LogUtil logger = LogUtil.logger(MysqlDistributionLockImpl.class);
	private ThreadLocal<String> lockFlag = new ThreadLocal<String>();
	@Autowired
	private MethodLockService methodLockService;
	@Override
	public boolean lock(String lockKey) {
		MethodLock methodLock = new MethodLock(lockKey);
		boolean result = false;
		try {
			 result = methodLockService.insert(methodLock);
			// 如果获取锁失败，按照传入的重试次数进行重试
		} catch (Exception e1) {
			while ((!result)) {
				try {
					// logger.debug("lock failed, retrying..." + 100);
					Thread.sleep(300);
					result = methodLockService.insert(methodLock);
				} catch (Exception e) {
				}
			}
		}
		lockFlag.set(methodLock.getUuid());
		logger.info(Thread.currentThread().getName() + "加锁成功 ++++ 22222");
		return true;
	}

	@Override
	public void unlock(String lockKey) {
		boolean result = methodLockService.deleteByMethodAndUUid(lockKey, lockFlag.get());
	    if (result) {
			logger.info(Thread.currentThread().getName() + "解锁成功------------------");
		}else {
		//	logger.info(Thread.currentThread().getName() + "解锁失败------------------");
		}
	}

}

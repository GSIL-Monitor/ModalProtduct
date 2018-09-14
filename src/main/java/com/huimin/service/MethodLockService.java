package com.huimin.service;

import com.baomidou.mybatisplus.service.IService;
import com.huimin.entity.MethodLock;

/**
 * <p>
 * 锁定中的方法 服务类
 * </p>
 *
 * @author zhuliang
 * @since 2018-07-10
 */
public interface MethodLockService extends IService<MethodLock> {
	
	/**
	 * 根据方法名和唯一标识删除锁
	 * @param method
	 * @param uuid
	 * @return
	 */
	boolean deleteByMethodAndUUid(String method, String uuid);
}

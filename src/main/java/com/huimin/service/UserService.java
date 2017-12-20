package com.huimin.service;

import com.baomidou.mybatisplus.service.IService;
import com.huimin.entity.security.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuliang
 * @since 2017-12-20
 */
public interface UserService extends IService<User> {
	
	User selectByAccount(String account);
}

package com.huimin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huimin.entity.security.User;
import com.huimin.mapper.UserMapper;
import com.huimin.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuliang
 * @since 2017-12-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Override
	@Transactional
	public User selectByAccount(String account) {
		insert(new User());
//		UserService userService = (UserService)AopContext.currentProxy();
//		userService.insert(new User());
		return selectOne(new EntityWrapper<User>().eq(User.ACCOUNT, account));
	}
	
	@Override
	public boolean insert(User entity) {
		return super.insert(entity);
	}
}

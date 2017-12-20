package com.huimin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huimin.entity.security.Role;
import com.huimin.mapper.RoleMapper;
import com.huimin.service.RoleService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuliang
 * @since 2017-12-20
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

	@Override
	public List<Role> selectRolesByUserId(Integer userId) {
		return baseMapper.selectRolesByUserId(userId);
	}
	
}

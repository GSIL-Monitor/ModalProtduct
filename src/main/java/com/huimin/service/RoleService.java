package com.huimin.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.huimin.entity.security.Role;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuliang
 * @since 2017-12-20
 */
public interface RoleService extends IService<Role> {
	
	List<Role> selectRolesByUserId(Integer userId);
}

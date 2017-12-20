package com.huimin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huimin.entity.security.Role;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhuliang
 * @since 2017-12-20
 */
public interface RoleMapper extends BaseMapper<Role> {

	@Select("SELECT r.`id`,r.`name` FROM `role` r INNER JOIN `user_role` ur ON r.`id` = ur.`role_id` AND ur.`user_id` = #{userId}")
	List<Role> selectRolesByUserId(Integer userId);

}
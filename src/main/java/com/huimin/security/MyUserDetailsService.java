package com.huimin.security;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.huimin.entity.security.Role;
import com.huimin.entity.security.User;
import com.huimin.service.RoleService;
import com.huimin.service.UserService;

@Component
public class MyUserDetailsService implements UserDetailsService{

	private UserService userService;
	
	private RoleService roleService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.selectByAccount(username);
		if (user == null) {
			throw new UsernameNotFoundException("账号不存在");
		}
		List<Role> roles = roleService.selectRolesByUserId(user.getId());
		return new UserDetail(user, roles);
	}

}

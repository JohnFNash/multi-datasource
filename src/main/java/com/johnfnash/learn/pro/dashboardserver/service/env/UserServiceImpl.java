package com.johnfnash.learn.pro.dashboardserver.service.env;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnfnash.learn.pro.dashboardserver.core.DataSource;
import com.johnfnash.learn.pro.dashboardserver.dao.env.UserMapper;
import com.johnfnash.learn.pro.dashboardserver.domain.User;

@Service("userService")
@DataSource("dataSourceEnv")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getAll() {
		return userMapper.getAll();
	}

}

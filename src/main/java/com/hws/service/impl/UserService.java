package com.hws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hws.dao.UserMapper;
import com.hws.domain.User;
import com.hws.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findOne() {
		return userMapper.findOne();
	}

}

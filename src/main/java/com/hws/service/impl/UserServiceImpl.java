package com.hws.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hws.authorization.manager.TokenManager;
import com.hws.authorization.model.TokenModel;
import com.hws.dao.UserMapper;
import com.hws.domain.User;
import com.hws.domain.dto.UserDto;
import com.hws.service.IUserService;
import com.hws.utils.BeansConvert;
import com.hws.utils.CountNumUtil;
import com.hws.utils.Encryption;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private TokenManager redisTokenManager;
	
	@Override
	public UserDto login(User user,String token,HttpServletRequest request) {
		User user1 = userMapper.findOne(user);
		user.setSalt(user1.getSalt());
		String password = user.getPassword();
		user.setPassword(user1.getPassword());
		if(Encryption.checkPassword(user,password)) {
			TokenModel model = new TokenModel(user1.getId(), token, user1.getRole());
			redisTokenManager.createToken(model);
			UserDto userDto = BeansConvert.copyNullProperties(UserDto.class,user1);
			userDto.setToken(token);
			return userDto;
		}
		else {
			System.out.println("用户名或密码错误");
			return null;
		}
	}

	@Override
	public void register(User user) {
		Encryption.encryptPasswd(user);
		userMapper.insert(user);
	}

	@Override
	public void loginOut(String token) {
		redisTokenManager.deleteToken(token);
	}

	@Override
	public UserDto findById(Long userId) {
		return BeansConvert.copyNullProperties(UserDto.class, userMapper.findById(userId));
	}

	@Override
	public List<UserDto> findAll() {
		List<User> userList = userMapper.findAll();
		List<UserDto> userDtoList = new ArrayList<>(userList.size());
		for(int i=0;i<userList.size();i++)
			userDtoList.add(BeansConvert.copyNullProperties(UserDto.class, userList.get(i)));
		return userDtoList;
	}

	@Override
	public Long count() {
		return userMapper.count();
	}

	@Override
	public List<Integer> countNum() {
		return CountNumUtil.ruleCountNum(userMapper.countNum());
	}

}

package com.hws.service.impl;


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
import com.hws.utils.Encryption;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private TokenManager redisTokenManager;
	
	@Override
	public UserDto login(User user,String token) {
		User user1 = userMapper.findOne(user);
		user.setSalt(user1.getSalt());
		String password = user.getPassword();
		user.setPassword(user1.getPassword());
		if(Encryption.checkPassword(user,password)) {
			TokenModel model = new TokenModel(user.getId(), token, user1.getRole());
			redisTokenManager.createToken(model);
			System.out.println("登录成功");
			System.out.println(user1);
			
			return BeansConvert.copyNullProperties(UserDto.class,user1);
		}
		else {
			System.out.println("error");
			return null;
		}
	}

	@Override
	public Integer register(User user) {
		Encryption.encryptPasswd(user);
		return userMapper.insert(user);
	}

	@Override
	public Object loginOut(String token) {
		redisTokenManager.deleteToken(token);
		return null;
	}

}

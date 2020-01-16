package com.hws.service;

import com.hws.domain.User;
import com.hws.domain.dto.UserDto;

public interface IUserService {
	Integer register(User user);
	Object loginOut(String token);
	UserDto login(User user, String token);
}

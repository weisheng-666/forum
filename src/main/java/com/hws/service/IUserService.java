package com.hws.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hws.domain.User;
import com.hws.domain.dto.UserDto;

public interface IUserService {
	void register(User user);
	void loginOut(String token);
	UserDto login(User user, String token, HttpServletRequest request);
	UserDto findById(Long currentUserId);
	List<UserDto> findAll();
	Long count();
	List<Integer> countNum();
}

package com.hws.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hws.domain.User;

@Mapper
public interface UserMapper {
	User findOne(User user);//用户登录
	Integer insert(User user);//用户注册
	void updateJoinDay();//定时器每天更新用户的注册天数
}

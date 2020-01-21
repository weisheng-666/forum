package com.hws.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hws.domain.User;

@Mapper
public interface UserMapper {
	User findOne(User user);//用户登录
	void insert(User user);//用户注册
	void updateJoinDay();//定时器每天更新用户的注册天数
	User findById(Long currentUserId);
	List<User> findAll();
	Long count();
	List<Map<String,String>> countNum();
}

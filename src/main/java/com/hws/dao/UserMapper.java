package com.hws.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hws.domain.User;

@Mapper
public interface UserMapper {
	User findOne();

}

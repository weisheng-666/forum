package com.hws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hws.authorization.annotation.Authorization;
import com.hws.config.ResultStatus;
import com.hws.model.ResultModel;
import com.hws.service.IUserService;

@RestController
@Authorization(role = {"admin","user"})
public class TestController {
	
	@Autowired
	private IUserService userService;
	
	/*
	 * @RequestMapping("test") public ResultModel test() {
	 * System.out.println("test"); ResultModel rm = new
	 * ResultModel(0,"",userService.login()); return rm; }
	 */

}

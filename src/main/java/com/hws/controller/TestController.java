package com.hws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hws.authorization.annotation.Authorization;
import com.hws.config.ResultStatus;
import com.hws.model.ResultModel;
import com.hws.service.IUserService;

@RestController
public class TestController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/log/getDataLog")
	public Object log() {
		System.out.println("1");
		 return new ResponseEntity<>(ResultModel.ok(),HttpStatus.OK);
	}
	/*
	 * @RequestMapping("test") public ResultModel test() {
	 * System.out.println("test"); ResultModel rm = new
	 * ResultModel(0,"",userService.login()); return rm; }
	 */

}

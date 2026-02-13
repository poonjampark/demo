package com.pzp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pzp.model.User;
import com.pzp.service.user.LoginService;

import util.panzhanpeng.response.SingleResponse;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private LoginService LoginService;

	@PostMapping("/login")
	public @ResponseBody SingleResponse<User> login(@RequestBody User user) {
		return LoginService.login(user);
	}
	
}

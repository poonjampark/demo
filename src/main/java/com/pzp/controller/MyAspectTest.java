package com.pzp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pzp.interceptor.aop.UserValidator;
import com.pzp.model.User;
import com.pzp.service.user.UserService;

@Controller
public class MyAspectTest {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/validator")
	@ResponseBody
	public User validatorAndPrint(@RequestBody User user) {
		User target = new User();
		target.setId(user.getId());
		target.setName(user.getName());
		UserValidator userValidator = (UserValidator) userService;
		if (userValidator.validator(user)) {
			System.out.println(user.toString());
		}
		return user;
	}
	
}

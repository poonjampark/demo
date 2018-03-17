/**
 * 
 */
package com.pzp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pzp.service.UserServiceImpl;

/**
 *<p>Title: UserController</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月15日上午12:21:33
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("listUser")
	public String listUser() {
		System.out.println("进来了");
		return userServiceImpl.listUser(1, 10);
	}
}

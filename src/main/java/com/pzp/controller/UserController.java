/**
 * 
 */
package com.pzp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("listUser")
	public String listUser() {
		LOGGER.info("日志测试");
		return userServiceImpl.listUser(1, 10);
	}
}

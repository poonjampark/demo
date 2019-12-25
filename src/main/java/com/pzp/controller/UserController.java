/**
 * 
 */
package com.pzp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pzp.model.User;
import com.pzp.service.user.UserService;

/**
 *<p>Title: 用户控制器类</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月15日上午12:21:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 根据页码获取数据
	 * @param pageNmuber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/listUser", method = RequestMethod.GET)
	public String listUser(int pageNmuber, int pageSize) {
		return JSON.toJSONString(userService.listUsers(pageNmuber, pageSize));
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@RequestBody User user) {
		return JSON.toJSONString(userService.addUser(user));
	}
	
	
}

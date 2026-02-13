/**
 * 
 */
package com.pzp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pzp.annotation.IsLogin;
import com.pzp.model.User;
import com.pzp.service.user.UserBatchService;
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
	
	@Autowired
	private UserBatchService userBatchService;
	
	/**
	 * 根据页码获取数据
	 * @param pageNmuber
	 * @param pageSize
	 * @return
	 */
	@IsLogin(value = "false")
	@GetMapping(value = "/listUser")
	public String listUser(int pageNumber, int pageSize) {
		return JSON.toJSONString(userService.listUsers(pageNumber, pageSize));
	}
	
	/**
	 * 根据姓名和账号分页查询用户
	 * @param pageNmuber
	 * @param pageSize
	 * @return
	 */
	@IsLogin(value = "false")
	@GetMapping(value = "/listUserByNameAndAccount")
	public String listUserByNameAndAccount(String name, String account, int pageNum, int pageSize) {
		return JSON.toJSONString(userService.findUsersByNameAndAccount(name, account, pageNum, pageSize));
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@PostMapping("/user")
	public String insert(@RequestBody User user) {
		return JSON.toJSONString(userService.addUser(user));
	}
	
	/**
	 * 批量新增用户
	 * @param user
	 * @return
	 */
	@PostMapping("/users")
	public String insert(@RequestBody List<User> users) {
		return JSON.toJSONString(userBatchService.insertUsers(users));
	}
	
	/**
	 * 批量新增用户
	 * @param user
	 * @return
	 */
	@PostMapping("/batchUsers")
	public String batchInsert(@RequestBody List<User> users) {
		return JSON.toJSONString(userService.batchAddUser(users));
	}
	
}

package com.pzp.service.user.Impl;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.pzp.model.User;
import com.pzp.service.user.UserService;

import util.panzhanpeng.response.MutilResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void testListUsers() {
		MutilResponse<User> users = userService.listUsers(0, 10);
		assertTrue("数目大于0则表示成功", users.getDates().size() > 0);
	}

	@Test
	public void testAddUser() {
		String paramString = "{\"name\":\"pzp\",\"account\":\"13286591459\",\"password\":\"13189190858\",\"ip\":\"192.168.224.1\",\"credits\":\"5\"}";
		try {
			User user = JSONObject.parseObject(paramString, User.class);
			userService.addUser(user);
		} catch (Exception e) {
			assertFalse("添加失败", false);
		}
		assertTrue(true);
	}

}

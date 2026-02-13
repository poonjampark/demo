package com.pzp.service.user.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pzp.model.User;
import com.pzp.service.user.UserBatchService;
import com.pzp.service.user.UserService;

@Service
public class UserBatchServiceImpl implements UserBatchService {
	
	@Autowired
	private UserService userService;
	
	@Override
	@ResponseBody
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public int insertUsers(List<User> users) {
		int count = 0;
		for (User user : users) {
			userService.addUser(user);
			count++;
		}
		return count;
	}

}

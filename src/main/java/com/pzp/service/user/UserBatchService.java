package com.pzp.service.user;

import java.util.List;

import com.pzp.model.User;

public interface UserBatchService {

	public int insertUsers(List<User> users);
	
}

package com.pzp.service.user;

import com.pzp.model.User;

import util.panzhanpeng.response.MutilResponse;
import util.panzhanpeng.response.Response;

/**
 * 用户业务接口类
 * @author panzhanpeng
 * @date
 */
public interface UserService {
	
	/**
	 * 获取所有用户
	 * @return
	 */
	MutilResponse<User> listUsers(int pageNmuber, int pageSize);
	
	/**
	 * 新增用户
	 */
	Response addUser(User user);
	
}

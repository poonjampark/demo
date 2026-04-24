package com.pzp.service.user;

import com.pzp.model.User;

import com.pzp.util.response.SingleResponse;

/**
 * 登录接口类
 * @author panzhanpeng
 * @date
 */
public interface LoginService {
	
	/**
	 * 登录
	 *
	 * @return
	 */
	SingleResponse<User> login(User user);
	
}

/**
 * 
 */
package com.pzp.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzp.constant.UserConstant;
import com.pzp.mapper.LoginMapper;
import com.pzp.model.User;
import com.pzp.service.user.LoginService;

import util.panzhanpeng.response.SingleResponse;

/**
 *<p>Title: UserImpl</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月14日下午11:49:13
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public SingleResponse<User> login(User user) {
		User result = loginMapper.login(user);
		if (user != null) {
			return SingleResponse.buildSuccess(UserConstant.SUCCESS, UserConstant.SUCCESS_MSG, result);
		} else {
			return SingleResponse.buildFail(UserConstant.FAIL, UserConstant.FAIL_MSG, result);
		}
	}
	
}

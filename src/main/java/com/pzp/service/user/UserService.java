package com.pzp.service.user;

import java.util.List;

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
	 * 根据姓名和账号分页查询用户
	 * @return
	 */
	MutilResponse<User> findUsersByNameAndAccount(String name, String account, int pageNum, int pageSize);
	
	/**
	 * 新增单个用户
	 */
	Response addUser(User user);
	
	/**
	 * 批量新增用户
	 */
	Response batchAddUser(List<User> users);
	
}

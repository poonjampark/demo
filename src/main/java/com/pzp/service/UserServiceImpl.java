/**
 * 
 */
package com.pzp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzp.dao.UserDao;
import com.pzp.model.User;

/**
 *<p>Title: UserImpl</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月14日下午11:49:13
 */
@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 获取所有用户
	 * @param pageNmuber
	 * @param pageSize
	 * @return
	 */
	public String listUser(int pageNmuber, int pageSize) {
		PageHelper.startPage(pageNmuber, pageSize);
		List<User> users = userDao.listUsers();
		return JSON.toJSONString(new PageInfo<User>(users));
	}
}

/**
 * 
 */
package com.pzp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pzp.model.User;

/**
 *<p>Title: UserDao</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月14日下午11:39:17
 */
@MapperScan
public interface UserMapper {

	/**
	 * 获取所有用户
	 * @return
	 */
	List<User> listUsers();
	
	/**
	 * 新增用户
	 */
	void insert(User user);
	
}

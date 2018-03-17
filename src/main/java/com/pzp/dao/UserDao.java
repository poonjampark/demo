/**
 * 
 */
package com.pzp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pzp.model.User;

/**
 *<p>Title: UserDao</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月14日下午11:39:17
 */
public interface UserDao {

	/**
	 * 获取所有用户
	 * @return
	 */
	@Select("select * from user")
	List<User> listUsers();
}

/**
 * 
 */
package com.pzp.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.pzp.model.User;

/**
 *<p>Title: UserDao</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月14日下午11:39:17
 */
@MapperScan
public interface LoginMapper {

	/**
	 * 登录
	 * @return
	 */
	User login(User user);
	
}

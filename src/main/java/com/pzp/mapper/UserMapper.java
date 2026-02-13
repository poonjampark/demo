/**
 * 
 */
package com.pzp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pzp.model.User;

/**
 * 用户
 * @author panzhanpeng
 * @date 2018年3月14日下午11:39:17
 */
@MapperScan
public interface UserMapper {

	/**
	 * 分页查询用户
	 * @param pageNum 页码
	 * @param pageSize 页数大小
	 * @return
	 */
	List<User> findUsersByPage(int pageNum, int pageSize);
	
	/**
	 * 根据姓名和账号分页查询用户
	 * @param name 姓名
	 * @param account 账号
	 * @param pageNum 页码
	 * @param pageSize 页数大小
	 * @return
	 */
	List<User> findUsersByNameAndAccount(String name, String account, int pageNum, int pageSize);
	
	/**
	 * 新增用户
	 */
	void addUser(User user);
	
	/**
	 * 批量新增用户
	 */
	void addUsers(List<User> users);
	
	/**
	 * 修改用户
	 */
	void updUser(User user);
	
	/**
	 * 根据用户id查询用户
	 * @return
	 */
	User findUserById(String userId);
	
	/**
	 * 根据用户id删除用户
	 */
	void delUserById(String userId);
	
	
}

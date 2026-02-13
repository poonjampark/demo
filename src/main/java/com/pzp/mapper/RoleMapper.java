/**
 * 
 */
package com.pzp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pzp.model.Role;

/**
 * 角色权限
 * @author panzhanpeng
 *
 */
@MapperScan
public interface RoleMapper {

	/**
	 * 新增权限
	 * @return
	 */
	void addRole(Role role);
	
	/**
	 * 修改权限
	 */
	void updRole(Role role);
	
	/**
	 * 根据用户id查询权限
	 */
	List<Role> findRolesByUserId(String userId);
	
	/**
	 * 根据id查询权限
	 */
	Role findRoleById(String roleId);
	
	/**
	 * 根据id删除权限
	 */
	Role delRoleById(String roleId);
	
}

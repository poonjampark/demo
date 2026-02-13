package com.pzp.model;

import org.springframework.boot.persistence.autoconfigure.EntityScan;

/**
 * 角色权限类
 * @author panzhanpeng
 *
 */
@EntityScan
public class Role {

	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 权限名称
	 */
	private String roleName;
	
	/**
	 * 权限等级
	 */
	private String roleLevel;
	
	/**
	 * 备注
	 */
	private String remarks;
	
	/**
	 * 最后修改人
	 */
	private String lastUpdateName;
	
	/**
	 * 最后修改时间
	 */
	private String lastUpdateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(String roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLastUpdateName() {
		return lastUpdateName;
	}

	public void setLastUpdateName(String lastUpdateName) {
		this.lastUpdateName = lastUpdateName;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
}

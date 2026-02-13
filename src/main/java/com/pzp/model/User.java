/**
 * 
 */
package com.pzp.model;

import java.io.Serializable;

import org.springframework.boot.persistence.autoconfigure.EntityScan;


/**
 *用户类
 * @author panzhanpeng
 * @date 2018年3月12日下午9:02:30
 */
@EntityScan
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4130538254948193999L;

	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 账号
	 */
	private String account;
	
	/**
	 * 密码
	 */
	private String password;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

/**
 * 
 */
package com.pzp.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 *<p>Title: User</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月12日下午9:02:30
 */
@EntityScan
public class User {

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
	 * 登录ip地址
	 */
	private String ip;
	
	/**
	 * 积分
	 */
	private Integer credits;

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}

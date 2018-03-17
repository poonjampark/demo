/**
 * 
 */
package com.pzp.model;

/**
 *<p>Title: User</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月12日下午9:02:30
 */
public class User {

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 用户名
	 */
	private String name;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
}

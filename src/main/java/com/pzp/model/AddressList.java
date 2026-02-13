package com.pzp.model;

import org.springframework.boot.persistence.autoconfigure.EntityScan;

/**
 * 通讯录类
 * @author panzhanpeng
 *
 */
@EntityScan
public class AddressList {
	
	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 单位名称
	 */
	private String companyName;
	
	/**
	 * 人员类型
	 */
	private String typeName;
	
	/**
	 * 职位
	 */
	private String post;
	
	/**
	 * 姓名
	 */
	private String userName;
	
	/**
	 * 联系电话(固话、手机)
	 */
	private String telephone;
	
	/**
	 * 手机
	 */
	private String mobile;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 所属分会
	 */
	private String belongTo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBelongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}

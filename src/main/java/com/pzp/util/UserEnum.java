package com.pzp.util;

import util.panzhanpeng.response.EnumBaseI;

public enum UserEnum implements EnumBaseI {
	
	USER_BIZ_ACCOUNT_NULL("000001", "用户账号不能为空"),
	USER_BIZ_PARAM_NULL("000002", "用户入参不能为空"),
	USER_TEH_LIST_EXCEPTION("000003", "查找全部用户失败"),
	USER_BIZ_NAME_NULL("000004", "用户姓名不能为空"),
	USER_BIZ_PASSWORD_NULL("000005", "用户密码不能为空"),
	USER_TEH_ADD_USER_EXCEPTION("000006", "新增用户失败");

	private UserEnum(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	private String errorCode;
	
	private String errorMsg;
	
	@Override
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

}

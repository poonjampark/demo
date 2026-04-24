package com.pzp.util;


import com.pzp.util.response.EnumBaseI;

public enum BookEnum implements EnumBaseI {
	
	BOOK_BIZ_ID_NULL("000001", "书本ID不能为空"),
	BOOK_BIZ_STOCK_NULL("000002", "书本库存为空"),
	BOOK_BIZ_BUYBOOK_EXCEPTION("000002", "购买书本发生异常"),
	BOOK_TEH_LIST_EXCEPTION("000003", "查找全部书本失败");

	private BookEnum(String errorCode, String errorMsg) {
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

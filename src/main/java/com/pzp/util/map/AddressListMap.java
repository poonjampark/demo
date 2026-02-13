package com.pzp.util.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于excel导入时的字段对应
 * @author panzhanpeng
 *
 */
public class AddressListMap {

	static Map<String, String> addressListMap = new HashMap<String, String>();
	
	public static Map<String, String> getMap(){
		addressListMap.put("companyName", "单位名称");
		addressListMap.put("typeName", "人员类型");
		addressListMap.put("post", "职位");
		addressListMap.put("userName", "姓名");
		addressListMap.put("telephone", "联系电话");
		addressListMap.put("mobile", "手机");
		addressListMap.put("email", "邮箱");
		addressListMap.put("belongTo", "所属分会");
		return addressListMap;
	}
	
}

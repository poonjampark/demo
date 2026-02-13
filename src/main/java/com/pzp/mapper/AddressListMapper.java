/**
 * 
 */
package com.pzp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pzp.model.AddressList;

/**
 * 通讯录
 * @author panzhanpeng
 * @date 2018年3月28日下午11:39:17
 */
@MapperScan
public interface AddressListMapper {

	/**
	 * 分页查询通讯录
	 * @param pageNum 页码
	 * @param pageSize 页数大小
	 * @return
	 */
	List<AddressList> findAddressLists(int pageNum, int pageSize);
	
	/**
	 * 新增通讯录
	 */
	void addAddressList(AddressList addressList);
	
	/**
	 * 修改通讯录
	 */
	void updAddressList(AddressList addressList);
	
	/**
	 * 根据用户id查询通讯录
	 * @return
	 */
	AddressList findAddressListById(String addressListId);
	
	/**
	 * 根据用户id删除通讯录
	 */
	void delAddressListById(String addressListId);
	
}

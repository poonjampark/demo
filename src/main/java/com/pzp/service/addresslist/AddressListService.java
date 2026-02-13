package com.pzp.service.addresslist;

import java.util.List;

import com.pzp.model.AddressList;

import util.panzhanpeng.response.MutilResponse;
import util.panzhanpeng.response.Response;

public interface AddressListService {

	/**
	 * 导入通讯录
	 * @param addressLists
	 * @return
	 */
	Response importAddressList(List<AddressList> addressLists);
	
	/**
	 * 根据页码获取通讯录
	 * @return
	 */
	MutilResponse<AddressList> findAddressListsByPage(int pageNmuber, int pageSize);
	
}

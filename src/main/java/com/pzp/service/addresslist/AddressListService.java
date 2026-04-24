package com.pzp.service.addresslist;

import com.pzp.model.AddressList;
import com.pzp.util.response.MutilResponse;
import com.pzp.util.response.Response;

import java.util.List;

public interface AddressListService {

	/**
	 * 导入通讯录
	 *
	 * @param addressLists
	 * @return
	 */
	Response importAddressList(List<AddressList> addressLists);
	
	/**
	 * 根据页码获取通讯录
	 *
	 * @return
	 */
	MutilResponse<AddressList> findAddressListsByPage(int pageNmuber, int pageSize);
	
}

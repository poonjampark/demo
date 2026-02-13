package com.pzp.service.addresslist.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.pzp.mapper.AddressListMapper;
import com.pzp.model.AddressList;
import com.pzp.service.addresslist.AddressListService;

import util.panzhanpeng.response.MutilResponse;
import util.panzhanpeng.response.Response;

@Service
public class AddressListServiceImpl implements AddressListService {

	@Autowired
	private AddressListMapper addressListMapper;
	
	@Override
	public Response importAddressList(List<AddressList> addressLists) {
		try {
			for (AddressList address : addressLists) {
				addressListMapper.addAddressList(address);
			}
			return Response.buildSuccess();
		} catch (Exception e) {
			System.out.println("导入通讯录报错：" + e.getCause());
		}
		return Response.buildFail("100111", "导入通讯录报错，请检查文档正确性或联系管理员");
	}

	@SuppressWarnings("unchecked")
	@Override
	public MutilResponse<AddressList> findAddressListsByPage(int pageNmuber, int pageSize) {
		PageHelper.startPage(pageNmuber, pageSize);
		MutilResponse<AddressList> response = new MutilResponse<AddressList>();
		try {
			List<AddressList> addressLists = addressListMapper.findAddressLists(pageNmuber, pageSize);
			response = MutilResponse.buildSuccess(null, null, addressLists);
		} catch (Exception e) {
			System.out.println("导入通讯录报错：" + e.getCause());
			response = MutilResponse.buildFail("100112", "查询通讯录报错，请联系管理员", new ArrayList<AddressList>());
		}
		return response;
	}

}

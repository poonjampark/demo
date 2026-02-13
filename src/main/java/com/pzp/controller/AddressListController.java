package com.pzp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pzp.model.AddressList;
import com.pzp.service.addresslist.AddressListService;
import com.pzp.util.ExcelUtil;
import com.pzp.util.map.AddressListMap;

import util.panzhanpeng.response.Response;

/**
 * 通讯录控制器
 * @author panzhanpeng
 *
 */
@RestController
@RequestMapping("/addressList")
public class AddressListController {
	
	@Autowired
	private AddressListService addressListService;

	@PutMapping("/uploadExcel")
//	@ApiOperation(value = "导入通讯录", notes = "导入通讯录")
	public Response uploadExcel(MultipartFile file) throws Exception {
		List<AddressList> addressLists = ExcelUtil.readExcelFileToDTO(file, AddressList.class, AddressListMap.getMap());
		return addressListService.importAddressList(addressLists);
	}
	
	@GetMapping("/get")
//	@ApiOperation(value = "查询通讯录", notes = "根据页码获取通讯录")
	public Response getAddressLists(int pageNum, int pageSize) {
		return addressListService.findAddressListsByPage(pageNum, pageSize);
	}
	
}
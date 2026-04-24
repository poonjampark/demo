package com.pzp.service.sharedingbook;

import com.pzp.model.SharedingBook;
import com.pzp.util.response.Response;


/**
 * 书本接口类
 * @author panzhanpeng
 * @date
 */
public interface SharedingBookService {
	
	
	/**
	 * 新增书本
	 */
	Response addBook(SharedingBook sharedingBook);
	
	
}

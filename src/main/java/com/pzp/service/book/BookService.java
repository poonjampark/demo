package com.pzp.service.book;

import com.pzp.model.Book;

import util.panzhanpeng.response.MutilResponse;
import util.panzhanpeng.response.Response;

/**
 * 书本接口类
 * @author panzhanpeng
 * @date
 */
public interface BookService {
	
	/**
	 * 获取所有书本
	 * @return
	 */
	MutilResponse<Book> listBooks(int pageNmuber, int pageSize);
	
	/**
	 * 查询书本库存
	 * @param id
	 * @return
	 */
	int findBookStock(long id);
	
	/**
	 * 新增书本
	 */
	Response addBook(Book book);
	
	
	/**
	 * 购买书本
	 */
	Response buyBook(Book book, String userId);
	
}

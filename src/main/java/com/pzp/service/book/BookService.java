package com.pzp.service.book;

import com.pzp.model.Book;
import com.pzp.util.response.MutilResponse;
import com.pzp.util.response.Response;


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
	
	/**
	 * 根据ID查询书籍（分库分表）
	 */
	Book getById(Long id);
	
	/**
	 * 根据orderId查询书籍（分库分表）
	 */
	Book getByOrderId(Long orderId);
	
	/**
	 * 新增书籍（分库分表）
	 */
	Response addBookSharding(Book book);
	
	/**
	 * 更新书籍（分库分表）
	 */
	Response updateBookSharding(Book book);
	
	/**
	 * 删除书籍（分库分表）
	 */
	Response deleteBookSharding(Long id);
	
}

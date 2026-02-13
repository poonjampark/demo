/**
 * 
 */
package com.pzp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.pzp.model.Book;

/**
 * 书本
 * @author panzhanpeng
 * @date 2025年10月20日下午23:24:17
 */
@MapperScan
public interface BookMapper {

	/**
	 * 分页查询书本
	 * @param pageNum 页码
	 * @param pageSize 页数大小
	 * @return
	 */
	List<Book> findBooksByPage(int pageNum, int pageSize);
	
	/**
	 * 查询书本库存
	 * @return
	 */
	int findBookStock(long id);
	
	/**
	 * 新增书本
	 */
	void addBook(Book book);
	
	/**
	 * 购买书本
	 */
	void buyBook(Book book);
	
}

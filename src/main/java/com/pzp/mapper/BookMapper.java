/**
 * 
 */
package com.pzp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pzp.model.Book;

/**
 * 书本
 * @author panzhanpeng
 * @date 2025年10月20日下午23:24:17
 */
@Mapper
public interface BookMapper {

	/**
	 * 分页查询书本
	 * @param pageNum 页码
	 * @param pageSize 页数大小
	 * @return
	 */
	List<Book> findBooksByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
	
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
	
	/**
	 * 根据ID查询书籍（分库分表）
	 * @param id 书籍ID
	 * @return
	 */
	Book selectById(@Param("id") Long id);
	
	/**
	 * 根据orderId查询书籍（分库分表）
	 * @param orderId 订单ID
	 * @return
	 */
	Book selectByOrderId(@Param("orderId") Long orderId);
	
	/**
	 * 插入书籍（分库分表）
	 * @param book
	 * @return
	 */
	int insert(Book book);
	
	/**
	 * 更新书籍（分库分表）
	 * @param book
	 * @return
	 */
	int update(Book book);
	
	/**
	 * 删除书籍（分库分表）
	 * @param id
	 * @return
	 */
	int delete(@Param("id") Long id);
	
}

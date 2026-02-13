/**
 * 
 */
package com.pzp.mapper;

import org.mybatis.spring.annotation.MapperScan;

import com.pzp.model.SharedingBook;

/**
 * 书本
 * @author panzhanpeng
 * @date 2026年1月19日下午23:24:17
 */
@MapperScan
public interface SharedingBookMapper {

	/**
	 * 新增书本
	 */
	void addBook(SharedingBook book);
	
}

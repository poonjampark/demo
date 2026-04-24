/**
 * 
 */
package com.pzp.controller;

import com.alibaba.fastjson.JSON;
import com.pzp.annotation.IsLogin;
import com.pzp.model.Book;
import com.pzp.model.SharedingBook;
import com.pzp.service.book.BookService;
import com.pzp.service.sharedingbook.SharedingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *<p>Title: 书本控制器类</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2025年10月21日上午10:23:33
 */
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private SharedingBookService sharedingBookService;
	
	/**
	 * 根据页码获取数据
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@IsLogin(value = "false")
	@GetMapping(value = "/books")
	public String listBook(int pageNumber, int pageSize) {
		return JSON.toJSONString(bookService.listBooks(pageNumber, pageSize));
	}
	
	/**
	 * 新增书
	 * @param book
	 * @return
	 */
	@PostMapping("/book")
	public String insert(@RequestBody Book book) {
		return JSON.toJSONString(bookService.addBook(book));
	}
	
	/**
	 * 购买书本
	 * @return
	 */
	@PostMapping("/buy/book/{userId}")
	public String buy(@RequestBody Book book, @PathVariable String userId) {
		int i = 1/0;
		return JSON.toJSONString(bookService.buyBook(book, userId));
	}
	
	/**
	 * 新增书,分表分库
	 * @return
	 */
	@PostMapping("/sharedingbook")
	public String sharedingInsert(@RequestBody SharedingBook sharedingBook) {
		return JSON.toJSONString(sharedingBookService.addBook(sharedingBook));
	}
	
}

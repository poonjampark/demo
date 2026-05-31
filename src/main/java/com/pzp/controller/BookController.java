/**
 * 
 */
package com.pzp.controller;

import com.alibaba.fastjson.JSON;
import com.pzp.annotation.IsLogin;
import com.pzp.model.Book;
import com.pzp.service.book.BookService;
import com.pzp.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
	 * 新增书籍（分库分表）- 使用Book实体
	 * @param book 书籍信息
	 * @return
	 */
	@PostMapping("/sharding/add")
	public Response addBookSharding(@RequestBody Book book) {
		return bookService.addBookSharding(book);
	}
	
	/**
	 * 查询书籍（分库分表）- 使用Book实体
	 * @param id 书籍ID
	 * @return
	 */
	@GetMapping("/sharding/{id}")
	public String getBookSharding(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<>();
		try {
			Book book = bookService.getById(id);
			result.put("success", true);
			result.put("data", book);
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return JSON.toJSONString(result);
	}
	
	/**
	 * 根据orderId查询书籍（分库分表）- 使用Book实体
	 * @param orderId 订单ID（分片键）
	 * @return
	 */
	@GetMapping("/sharding/order/{orderId}")
	public String getBookByOrderId(@PathVariable Long orderId) {
		Map<String, Object> result = new HashMap<>();
		try {
			Book book = bookService.getByOrderId(orderId);
			result.put("success", true);
			result.put("data", book);
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return JSON.toJSONString(result);
	}
	
	/**
	 * 更新书籍（分库分表）- 使用Book实体
	 * @param book 书籍信息
	 * @return
	 */
	@PutMapping("/sharding/update")
	public String updateBookSharding(@RequestBody Book book) {
		Map<String, Object> result = new HashMap<>();
		try {
			Response response = bookService.updateBookSharding(book);
			result.put("success", true);
			result.put("message", "更新成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "更新失败：" + e.getMessage());
		}
		return JSON.toJSONString(result);
	}
	
	/**
	 * 删除书籍（分库分表）- 使用Book实体
	 * @param id 书籍ID
	 * @return
	 */
	@DeleteMapping("/sharding/{id}")
	public String deleteBookSharding(@PathVariable Long id) {
		Map<String, Object> result = new HashMap<>();
		try {
			Response response = bookService.deleteBookSharding(id);
			result.put("success", true);
			result.put("message", "删除成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "删除失败：" + e.getMessage());
		}
		return JSON.toJSONString(result);
	}
	
}

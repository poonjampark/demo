/**
 * 
 */
package com.pzp.service.book.impl;

import com.github.pagehelper.PageHelper;
import com.pzp.enums.BookEnum;
import com.pzp.enums.UserEnum;
import com.pzp.mapper.BookMapper;
import com.pzp.model.Book;
import com.pzp.service.book.BookService;
import com.pzp.util.SnowflakeIdGenerator;
import com.pzp.util.response.MutilResponse;
import com.pzp.util.response.Response;
import org.apache.rocketmq.logging.org.slf4j.Logger;
import org.apache.rocketmq.logging.org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *<p>Title: BookServiceImpl</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2025年10月21日上午00:38:13
 */
@Service
public class BookServiceImpl implements BookService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private SnowflakeIdGenerator snowflakeIdGenerator;

//	@Autowired
//	private RedissonClient redissonClient;
	
	/**
	 * 获取所有用户
	 *
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MutilResponse<Book> listBooks(int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		MutilResponse<Book> response = new MutilResponse<Book>();
		List<Book> books = null;
		try {
			books = bookMapper.findBooksByPage(pageNumber, pageSize);
			response = MutilResponse.buildSuccess(null, null, books);
		} catch (Exception e) {
			LOGGER.error(UserEnum.USER_TEH_LIST_EXCEPTION.getErrorMsg(), e.getMessage());
			response = (MutilResponse<Book>) MutilResponse.buildFail(UserEnum.USER_TEH_LIST_EXCEPTION.getErrorCode(),
					UserEnum.USER_TEH_LIST_EXCEPTION.getErrorMsg());
		}
		return response;
	}
	
	@Override
	@ResponseBody
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Response addBook(Book book) {
		try {
			bookMapper.addBook(book);
			return Response.buildSuccess();
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			return Response.buildFail(UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorCode(),
					UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorMsg());
		}
	}

	/*
	 * @Override public Response buyBook(Book book, String userId) { try { int
	 * booknumber = bookMapper.findBookStock(book.getId()); if (booknumber <= 0) {
	 * return Response.buildFail(BookEnum.BOOK_BIZ_STOCK_NULL.getErrorCode(),
	 * BookEnum.BOOK_BIZ_STOCK_NULL.getErrorMsg()); } else { if
	 * (redisService.tryLock(String.valueOf(book.getId()), userId, 10)) {
	 * bookMapper.buyBook(book, booknumber - 1); } } } catch (Exception e) {
	 * LOGGER.debug(e.getMessage()); return
	 * Response.buildFail(BookEnum.BOOK_BIZ_BUYBOOK_EXCEPTION.getErrorCode(),
	 * BookEnum.BOOK_BIZ_BUYBOOK_EXCEPTION.getErrorMsg()); } finally {
	 * redisService.unLock(String.valueOf(book.getId()), userId); } return
	 * Response.buildSuccess(); }
	 */
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public Response buyBook(Book book, String userId) {
		String bookId = String.valueOf(book.getId());
//		RLock lock = null;
		try {
//			lock = redissonClient.getLock(bookId);
			int booknumber = bookMapper.findBookStock(book.getId());
			if (booknumber <= 0) {
				return Response.buildFail(BookEnum.BOOK_BIZ_STOCK_NULL.getErrorCode(),
						BookEnum.BOOK_BIZ_STOCK_NULL.getErrorMsg());
			} else {
//				if (lock.tryLock(10, TimeUnit.SECONDS)) {
//					try {
						book.setNumbers(booknumber - 1);
						bookMapper.buyBook(book);
//					} finally {
//						lock.unlock();
//					}
//				}
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			return Response.buildFail(BookEnum.BOOK_BIZ_BUYBOOK_EXCEPTION.getErrorCode(),
					BookEnum.BOOK_BIZ_BUYBOOK_EXCEPTION.getErrorMsg());
		} 
		return Response.buildSuccess();
	}

	@Override
	public int findBookStock(long id) {
		return bookMapper.findBookStock(id);
	}
	
	@Override
	public Book getById(Long id) {
		return bookMapper.selectById(id);
	}
	
	@Override
	public Book getByOrderId(Long orderId) {
		return bookMapper.selectByOrderId(orderId);
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public Response addBookSharding(Book book) {
		try {
			// 分库分表环境下必须使用分布式唯一ID，忽略前端传入的ID
			Long generatedId = snowflakeIdGenerator.generateId();
			book.setId(generatedId);
			LOGGER.info("生成分布式雪花ID: {}, 书名: {}, orderId: {}", generatedId, book.getName(), book.getOrderId());
			
			bookMapper.insert(book);
			return Response.buildSuccess();
		} catch (Exception e) {
			LOGGER.error("分库分表新增失败, book: {}", book, e);
			return Response.buildFail(UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorCode(),
					"分库分表新增失败：" + e.getMessage());
		}
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public Response updateBookSharding(Book book) {
		try {
			int rows = bookMapper.update(book);
			if (rows > 0) {
				return Response.buildSuccess();
			} else {
				return Response.buildFail("404", "记录不存在");
			}
		} catch (Exception e) {
			LOGGER.error("分库分表更新失败", e);
			return Response.buildFail(BookEnum.BOOK_TEH_UPDATE_EXCEPTION != null ?
							BookEnum.BOOK_TEH_UPDATE_EXCEPTION.getErrorCode() : "500",
					"分库分表更新失败：" + e.getMessage());
		}
	}
	
	@Override
	@Transactional(rollbackFor = {Exception.class})
	public Response deleteBookSharding(Long id) {
		try {
			int rows = bookMapper.delete(id);
			if (rows > 0) {
				return Response.buildSuccess();
			} else {
				return Response.buildFail("404", "记录不存在");
			}
		} catch (Exception e) {
			LOGGER.error("分库分表删除失败", e);
			return Response.buildFail("500", "分库分表删除失败：" + e.getMessage());
		}
	}
	
}
/**
 * 
 */
package com.pzp.service.book.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.pzp.mapper.BookMapper;
import com.pzp.model.Book;
import com.pzp.service.book.BookService;
import com.pzp.util.BookEnum;
import com.pzp.util.UserEnum;

import util.panzhanpeng.response.MutilResponse;
import util.panzhanpeng.response.Response;

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

//	@Autowired
//	private RedissonClient redissonClient;
	
	/**
	 * 获取所有用户
	 * @param pageNmuber
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
	
}
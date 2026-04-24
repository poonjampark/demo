/**
 * 
 */
package com.pzp.service.sharedingbook.impl;

import com.pzp.mapper.SharedingBookMapper;
import com.pzp.model.SharedingBook;
import com.pzp.service.sharedingbook.SharedingBookService;
import com.pzp.util.UserEnum;
import com.pzp.util.response.Response;
import org.apache.rocketmq.logging.org.slf4j.Logger;
import org.apache.rocketmq.logging.org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *<p>Title: BookServiceImpl</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2025年10月21日上午00:38:13
 */
@Service
public class SharedingBookServiceImpl implements SharedingBookService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SharedingBookServiceImpl.class);

	@Autowired
	private SharedingBookMapper sharedingBookMapper;

	
	@Override
	@ResponseBody
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Response addBook(SharedingBook sharedingBook) {
		try {
			sharedingBookMapper.addBook(sharedingBook);
			return Response.buildSuccess();
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			return Response.buildFail(UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorCode(),
					UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorMsg());
		}
	}

}
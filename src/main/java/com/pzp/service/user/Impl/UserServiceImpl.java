/**
 * 
 */
package com.pzp.service.user.Impl;

import java.util.List;

import com.pzp.util.response.MutilResponse;
import com.pzp.util.response.Response;
import org.apache.rocketmq.logging.org.slf4j.Logger;
import org.apache.rocketmq.logging.org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.pzp.mapper.UserMapper;
import com.pzp.model.User;
import com.pzp.service.user.UserService;
import com.pzp.util.UserEnum;


/**
 *<p>Title: UserImpl</p>
 * <p>Description: </p>
 * @author panzhanpeng
 * @date 2018年3月14日下午11:49:13
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 获取所有用户
	 *
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MutilResponse<User> listUsers(int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		MutilResponse<User> response = new MutilResponse<User>();
		List<User> users = null;
		try {
			users = userMapper.findUsersByPage(pageNumber, pageSize);
			response = MutilResponse.buildSuccess(null, null, users);
		} catch (Exception e) {
			LOGGER.error(UserEnum.USER_TEH_LIST_EXCEPTION.getErrorMsg(), e.getMessage());
			response = (MutilResponse<User>) MutilResponse.buildFail(UserEnum.USER_TEH_LIST_EXCEPTION.getErrorCode(),
					UserEnum.USER_TEH_LIST_EXCEPTION.getErrorMsg());
		}
		return response;
	}
	
	@Override
	@ResponseBody
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public Response addUser(User user) {
		Response response = checkParam(user);
		try {
			if (response != null) {
				return response;
			}
			userMapper.addUser(user);
			return Response.buildSuccess();
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			return Response.buildFail(UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorCode(),
					UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorMsg());
		}
	}
	
	/**
	 * 新增用户校验入参
	 * @param user
	 * @return
	 */
	private Response checkParam(User user) {
		if (user == null) {
			return Response.buildFail(UserEnum.USER_BIZ_PARAM_NULL.getErrorCode(),
					UserEnum.USER_BIZ_PARAM_NULL.getErrorMsg());
		}
		if ("".equals(user.getName()) && user.getName() != null) {
			return Response.buildFail(UserEnum.USER_BIZ_NAME_NULL.getErrorCode(),
					UserEnum.USER_BIZ_NAME_NULL.getErrorMsg());
		}
		if ("".equals(user.getAccount()) && user.getAccount() != null) {
			return Response.buildFail(UserEnum.USER_BIZ_ACCOUNT_NULL.getErrorCode(),
					UserEnum.USER_BIZ_ACCOUNT_NULL.getErrorMsg());
		}
		if ("".equals(user.getPassword()) && user.getPassword() != null) {
			return Response.buildFail(UserEnum.USER_BIZ_PASSWORD_NULL.getErrorCode(),
					UserEnum.USER_BIZ_PASSWORD_NULL.getErrorMsg());
		}
		return null;
	}

	@Override
	public MutilResponse<User> findUsersByNameAndAccount(String name, String account, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		MutilResponse<User> response = new MutilResponse<User>();
		List<User> users = null;
		try {
			users = userMapper.findUsersByNameAndAccount(name, account, pageNum, pageSize);
			response = MutilResponse.buildSuccess(null, null, users);
		} catch (Exception e) {
			LOGGER.error(UserEnum.USER_TEH_LIST_EXCEPTION.getErrorMsg(), e.getMessage());
			response = (MutilResponse<User>) MutilResponse.buildFail(UserEnum.USER_TEH_LIST_EXCEPTION.getErrorCode(),
					UserEnum.USER_TEH_LIST_EXCEPTION.getErrorMsg());
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
	public Response batchAddUser(List<User> users) {
		try {
			userMapper.addUsers(users);
			return Response.buildSuccess();
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			return Response.buildFail(UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorCode(),
					UserEnum.USER_TEH_ADD_USER_EXCEPTION.getErrorMsg());
		}
	}

}
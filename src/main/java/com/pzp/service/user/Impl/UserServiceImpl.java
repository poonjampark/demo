/**
 * 
 */
package com.pzp.service.user.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.pzp.mapper.UserMapper;
import com.pzp.model.User;
import com.pzp.service.user.UserService;
import com.pzp.util.UserEnum;

import util.panzhanpeng.response.MutilResponse;
import util.panzhanpeng.response.Response;

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
	 * @param pageNmuber
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MutilResponse<User> listUsers(int pageNmuber, int pageSize) {
		PageHelper.startPage(pageNmuber, pageSize);
		MutilResponse<User> response = new MutilResponse<User>();
		List<User> users = null;
		try {
			users = userMapper.listUsers();
			response = MutilResponse.buildSuccess(null, null, users);
		} catch (Exception e) {
			LOGGER.error(UserEnum.USER_TEH_LIST_EXCEPTION.getErrorMsg(), e.getMessage());
			response = (MutilResponse<User>) MutilResponse.buildFail(UserEnum.USER_TEH_LIST_EXCEPTION.getErrorCode(),
					UserEnum.USER_TEH_LIST_EXCEPTION.getErrorMsg());
		}
		return response;
	}
	
	@Override
	public Response addUser(User user) {
		Response response = new Response();
		try {
			response = checkParam(user);
			if (!StringUtils.isEmpty(response)) {
				return response;
			}
			user.setCredits(5);
			userMapper.insert(user);
			return Response.buildSuccess();
		} catch (Exception e) {
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
		if (StringUtils.isEmpty(user)) {
			return Response.buildFail(UserEnum.USER_BIZ_PARAM_NULL.getErrorCode(),
					UserEnum.USER_BIZ_PARAM_NULL.getErrorMsg());
		}
		if (StringUtils.isEmpty(user.getName())) {
			return Response.buildFail(UserEnum.USER_BIZ_NAME_NULL.getErrorCode(),
					UserEnum.USER_BIZ_NAME_NULL.getErrorMsg());
		}
		if (StringUtils.isEmpty(user.getAccount())) {
			return Response.buildFail(UserEnum.USER_BIZ_ACCOUNT_NULL.getErrorCode(),
					UserEnum.USER_BIZ_ACCOUNT_NULL.getErrorMsg());
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			return Response.buildFail(UserEnum.USER_BIZ_PASSWORD_NULL.getErrorCode(),
					UserEnum.USER_BIZ_PASSWORD_NULL.getErrorMsg());
		}
		return null;
	}

}

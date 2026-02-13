package com.pzp.interceptor.aop;

import com.pzp.model.User;

public class UserValidatorImpl implements UserValidator {

	@Override
	public boolean validator(User user) {
		System.out.println("新引进接口："  + UserValidator.class.getSimpleName());
		return user != null;
	}

}

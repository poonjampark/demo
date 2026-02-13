package com.pzp.interceptor.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class MyAspect {

	@DeclareParents(value = "com.pzp.service.test.impl.HelloServiceImpl+", 
			defaultImpl = UserValidatorImpl.class)
	public UserValidator userValidator;
	
}

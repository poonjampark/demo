package com.pzp.interceptor.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ManyAspect2 {

	@Pointcut("execution(* com.pzp.service.user.Impl.UserServiceImpl.listUsers(..))")
	public void manyAspect() {
		
	}
	
	@Before("manyAspect()")
	public void before() {
		System.out.println("before manyAspect3");
	}
	
	@After("manyAspect()")
	public void after() {
		System.out.println("after manyAspect3");
	}
	
	@AfterReturning("manyAspect()")
	public void afterReturn() {
		System.out.println("afterReturn manyAspect3");
	}
	
}

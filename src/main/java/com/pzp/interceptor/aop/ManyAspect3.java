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
@Order(2)
public class ManyAspect3 {

	@Pointcut("execution(* com.pzp.service.user.Impl.UserServiceImpl.listUsers(..))")
	public void manyAspect() {
		
	}
	
	@Before("manyAspect()")
	public void before() {
		System.out.println("before manyAspect2");
	}
	
	@After("manyAspect()")
	public void after() {
		System.out.println("after manyAspect2");
	}
	
	@AfterReturning("manyAspect()")
	public void afterReturn() {
		System.out.println("afterReturn manyAspect2");
	}
	
}

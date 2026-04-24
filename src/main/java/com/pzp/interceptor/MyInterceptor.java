package com.pzp.interceptor;

import com.alibaba.fastjson.JSON;
import com.pzp.util.response.MutilResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.pzp.model.User;


@Aspect
@Component
public class MyInterceptor {

	@Pointcut("execution(* com.pzp.service.user.Impl.UserServiceImpl.listUsers(..))")
	public void testAop() {
		
	}
	
	@Before("testAop()")
	public void before() {
		System.out.println("before....");
	}
	
	@After("testAop()")
	public void after() {
		System.out.println("after....");
	}
	
	@SuppressWarnings("unchecked")
	@Around("testAop()")
	public MutilResponse<User> around(ProceedingJoinPoint pjp) {
		System.out.println("before around....");
		Object[] args = pjp.getArgs();
		System.out.println("调用方法" + pjp.getSignature() + ",入参：" + JSON.toJSONString(args));
		System.out.println("after around....");
		MutilResponse<User> users = null;
		try {
			users = (MutilResponse<User>) pjp.proceed(args);
			System.out.println("请求返回结果为：" + JSON.toJSONString(users));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		return users;
	}
	
	@AfterReturning("testAop()")
	public void afterReturning() {
		System.out.println("afterReturning....");
	}
	
	@AfterThrowing("testAop()")
	public void afterThrowing() {
		System.out.println("afterThrowing....");
	}
	
}

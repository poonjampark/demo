package com.pzp.interceptor.test;

import java.lang.reflect.InvocationTargetException;

public class DiyMyInterceptor implements Interceptor {

	@Override
	public boolean before() {
		System.out.println("before.........");
		return true;
	}

	@Override
	public void after() {
		System.out.println("after......");
	}

	@Override
	public Object aroud(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
		System.out.println("before aroud.................");
		Object object = invocation.proceed();
		System.out.println("after aroud.................");
		return object;
	}

	@Override
	public void afterReturning() {
		System.out.println("afterReturning....");
	}

	@Override
	public void afterThrowing() {
		System.out.println("afterThrowing....");
	}

	@Override
	public boolean useAroud() {
		return true;
	}

}

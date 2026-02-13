package com.pzp.interceptor.test;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
	
	/**
	 * 事前调用
	 */
	public boolean before();
	
	/**
	 * 事后调用
	 */
	public void after();
	
	/**
	 * 环绕方法，取代原有方法
	 * @param invocation回调参数，可以通过它的 proceed 方法 回调原有事件
	 * @return 原有事件返回对象
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public Object aroud(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
	
	/**
	 * 方法正常返回
	 */
	public void afterReturning();
	
	/**
	 * 事后异常方法，当事件发生异常后执行
	 */
	public void afterThrowing();
	
	/**
	 * 是否使用环绕
	 * @return
	 */
	public boolean useAroud();
	
}

package com.pzp.interceptor.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {

	private Object target = null;
	
	private Interceptor interceptor = null;
	
	public static Object getProxyBean(Object target, Interceptor interceptor) {
		ProxyBean proxyBean = new ProxyBean();
		//保存被代理对象
		proxyBean.target = target;
		//保存拦截器
		proxyBean.interceptor = interceptor;
		//生成代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//异常标志
		boolean exceptionFlag = false;
		Invocation invocation = new Invocation(target, method, args);
		Object returnObject = null;
		try {
			if (this.interceptor.before()) {
				returnObject = this.interceptor.aroud(invocation);
			} else {
				returnObject = method.invoke(proxy, args);
			}
		} catch (Exception e) {
			//发生异常
			exceptionFlag = true;
		}
		this.interceptor.after();
		if (exceptionFlag) {
			this.interceptor.afterThrowing();
		} else {
			this.interceptor.afterReturning();
			return returnObject;
		}
		return null;
	}

}

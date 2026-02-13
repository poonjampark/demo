package com.pzp.interceptor.test;

import com.pzp.service.test.HelloService;
import com.pzp.service.test.impl.HelloServiceImpl;

public class TestProxy {

	public static void main(String[] args) {
		HelloService helloService = new HelloServiceImpl();
		HelloService helloServiceProxy = (HelloService) ProxyBean.getProxyBean(helloService, new DiyMyInterceptor());
		helloServiceProxy.sayHello("test AOP");
		System.out.println("name is null !!!!!!!!!!!!!!!!!!!!!!!");
		helloServiceProxy.sayHello(null);
	}
	
}

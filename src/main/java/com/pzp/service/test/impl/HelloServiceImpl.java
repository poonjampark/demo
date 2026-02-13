package com.pzp.service.test.impl;


import com.pzp.service.test.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public void sayHello(String str) {
		if (str.trim() == "" || str.isEmpty()) {
			throw new RuntimeException("str is null");
		}
		System.out.println("hello " + str);
	}

}

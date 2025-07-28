package com.pzp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.pzp.interceptor.AdminInterceptor;
import com.pzp.interceptor.InterceptorConfigurer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(InterceptorConfigurer.class);
		AdminInterceptor ad = ctx.getBean(AdminInterceptor.class);
		System.out.println(ad.toString());
	}

}

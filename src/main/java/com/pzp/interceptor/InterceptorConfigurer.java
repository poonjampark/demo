package com.pzp.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pzp.model.User;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {
	
//	public InterceptorConfigurer() {
//		System.out.println("init interceptor");
//	}
//	
	public void addItnerceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/user/*");
	}
	
	@Bean(name = "user")
	public User initUser() {
		User user = new User();
		user.setId("1");
		user.setName("test");
		return user;
	}

}

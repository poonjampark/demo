package com.pzp.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.pzp.annotation.IsLogin;

@Aspect
@Component
public class IsLoginAspcet {

	@Pointcut("@annotation(com.pzp.annotation.IsLogin)")
	public void isLogin() {
		
	}
	
	@Before("isLogin()")
	public void around(JoinPoint jp) {
		String className = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		Class clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("加载类失败");
		}
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				Annotation[] annotations = method.getAnnotations();
				for (Annotation annotation : annotations) {
					System.out.println("方法上所有注解" + annotation);
					if (method.isAnnotationPresent(IsLogin.class)) {
						String value = method.getAnnotation(IsLogin.class).value();
						System.out.println("注解" + annotation + "在类上,值为:" + value);
					}
				}
			}
		}
	}
	
}

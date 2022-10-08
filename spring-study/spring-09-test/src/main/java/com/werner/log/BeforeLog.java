package com.werner.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLog implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("第一種的方式:"+target.getClass().getName()+"的"+method.getName()+"方法");
		
	}
	

	
	
}

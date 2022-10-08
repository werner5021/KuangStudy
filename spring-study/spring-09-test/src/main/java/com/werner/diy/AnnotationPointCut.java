package com.werner.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {
	
	@Before("execution(* com.werner.service.UserServiceImpl.*(..))")
	public void before() {
		System.out.println("第三種，方法前");
	}
	
	@After("execution(* com.werner.service.UserServiceImpl.*(..))")
	public void after() {
		System.out.println("第三種，方法後");
	}
	@Around("execution(* com.werner.service.UserServiceImpl.*(..))")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		Object proceed = jp.proceed();
		System.out.println("第三種，環繞方法");
	}
	
	
}

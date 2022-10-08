package com.werner.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三: 使用註解方式實現AOP
@Aspect  //標註這個類是一個切面
public class AnnotationPointCut {
	@Before("execution(* com.werner.service.UserServiceImpl.*(..))")
	public void before() {
		System.out.println("=====方法執行前 註解版本=====");
	}
	
	@After("execution(* com.werner.service.UserServiceImpl.*(..))")
	public void after() {
		System.out.println("=====方法執行後 註解版本=====");
	}
	
	//在環繞增強中，我們可以給定一個參數，代表我們要獲取處理切入的點
	@Around("execution(* com.werner.service.UserServiceImpl.*(..))")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("=====環繞前 註解版本=====");

		//一般不會用這個功能，看看就好
		Signature signature= jp.getSignature();  //獲得簽名，也就是這個類的訊息
		System.out.println("signature:"+signature);

		//執行方法
		Object proceed = jp.proceed();
		
		System.out.println("=====環繞後 註解版本=====");
		
		System.out.println(proceed);
		
	}
}

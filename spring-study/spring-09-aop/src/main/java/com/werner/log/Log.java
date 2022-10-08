package com.werner.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class Log implements MethodBeforeAdvice{
	//這個方法會在我們執行方法之前自動去調用
	//method: 要執行的目標對象的方法
	//object: 參數
	//target: 目標對象
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println(target.getClass().getName()+"的"+method.getName()+"被執行了");
	}
}

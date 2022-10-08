package com.werner.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.werner.demo02.UserServiceImpl;

public class ProxyInvocationHandler implements InvocationHandler{

	private Object target;
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	public Object getProxy() {
		return Proxy.newProxyInstance(
				this.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				this);				
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object result = method.invoke(target, args);
		return result;
	}
	
	
	
	
}

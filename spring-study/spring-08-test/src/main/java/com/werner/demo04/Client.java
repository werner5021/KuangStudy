package com.werner.demo04;

import com.werner.demo02.UserService;
import com.werner.demo02.UserServiceImpl;

public class Client {
	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		
		ProxyInvocationHandler pih = new ProxyInvocationHandler();
		pih.setTarget(userService);
		
		UserService proxy = (UserService) pih.getProxy();
		proxy.add();
		proxy.delete();
	}
}

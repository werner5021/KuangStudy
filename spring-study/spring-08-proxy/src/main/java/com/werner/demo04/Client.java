package com.werner.demo04;

import com.werner.demo02.UserService;
import com.werner.demo02.UserServiceImpl;

public class Client {
	public static void main(String[] args) {
		//真實角色
		UserServiceImpl userService = new UserServiceImpl();
		//代理角色，不存在，找處理程序做出來
		ProxyInvocationHandler pih = new ProxyInvocationHandler();
		
		pih.setTarget(userService);  //設置要代理的對象
		//動態生成代理類
		UserService proxy = (UserService) pih.getProxy();
		 
		proxy.add();
		proxy.update();
	}
}

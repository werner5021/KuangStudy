package com.werner.demo02;

public class Client {
	
	public static void main(String[] args) {
		UserServiceImpl userService = new UserServiceImpl();
//		userService.add();  有了代理就不用調用真實角色
		
		//代理
		UserServiceProxy proxy = new UserServiceProxy(); 
		proxy.setUserService(userService);
		
		proxy.delete(); 		
	}	
}

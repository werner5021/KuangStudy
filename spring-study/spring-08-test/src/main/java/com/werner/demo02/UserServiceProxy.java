package com.werner.demo02;

public class UserServiceProxy implements UserService{

	private UserServiceImpl userService;
	
	public void setUserServiceImpl(UserServiceImpl userService) {
		this.userService = userService;
	}

	public void add() {
		userService.add();
		
	}

	public void delete() {
		userService.delete();
		
	}
		
	public  void fare() {
		System.out.println("收費");
	}

	public void seeHouse() {
		System.out.println("看房");
	}


}

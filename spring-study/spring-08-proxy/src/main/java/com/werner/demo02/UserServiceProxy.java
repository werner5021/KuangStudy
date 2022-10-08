package com.werner.demo02;

public class UserServiceProxy implements UserService{
	//要代理真實角色，所以把真實角色丟進來
	private UserServiceImpl userService;
	
	//Spring 建議使用set方法
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}

	//真實執行的增刪改查
	public void add() {
		log("add");
		userService.add();
	}

	public void delete() {
		log("delete");
		userService.delete();
	}

	public void update() {
		log("update");
		userService.update();
	}

	public void query() {
		log("query");
		userService.query();
	}
		
	//原本要寫很多遍的方法提成一個 → 公共方法
	//放在代理類裡面就不用改原有的方法
	public void log(String msg) {
		System.out.println("[Debug]使用了" + msg + "方法");
	}
	
	//為什麼要多一個類?不在原有的類裡面加?
	//改動原有的業務代碼，在公司中是大忌
	
	
}

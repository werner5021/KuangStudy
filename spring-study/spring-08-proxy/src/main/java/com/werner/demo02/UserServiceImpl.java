package com.werner.demo02;

//真實對象
public class UserServiceImpl implements UserService{

	public void add() {
		System.out.println("使用了xxx方法");  //如果在所有方法前都加一個log，這樣手動增加，一個方法就要修改一次		
		System.out.println("增加一個用戶");		
	}

	public void delete() {
		System.out.println("刪除一個用戶");	
	}

	public void update() {
		System.out.println("修改一個用戶");	
	}

	public void query() {
		System.out.println("查詢一個用戶");	
	}


	
}

package com.oop.demo10;

public class Test {
	public static void main(String[] args) {
		
		//正常的實例化
		Apple apple = new Apple();  
		
		//沒有名字初始化類，不用將實例保存到變量中
		new Apple().eat();
		
		new UserService(){
			public void hello() {
				
			}
		};
	}
}

class Apple{
	public void eat() {
		System.out.println("1");
	}
}

interface UserService{
	void hello();
}
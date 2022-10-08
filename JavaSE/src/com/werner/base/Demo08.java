package com.werner.base;

public class Demo08 {

	//類別變數 static
	static double salary = 2500;
	
	
	//屬性:變數
	
	//實作變數: 從屬於對象，如果不初始化，則會變成該類別的預設值
	//預設: 數值類型->0 0.0 / boolean->false 
	//除了基本類型，其他預設值都是 null
	String name;
	int age;
	
	//main 方法
	public static void main(String[] args) {
		
		//區域變數: 必須聲明和初始化值
		int i=10;
		System.out.println(i);
		
		//變數類別 名字 = new Demo08();
		Demo08 demo08 = new Demo08();
		System.out.println(demo08.age);
		System.out.println(demo08.name);
		
		//類別變數 static
		System.out.println(salary);
	}

	//其他方法
	
	
}

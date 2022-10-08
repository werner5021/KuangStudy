package com.oop.demo07;

public class Person {
	
	//2.賦初始值
	{
		//代碼塊(匿名代碼塊)	
		//程序在執行的時候，不能主動呼叫這裡 (非靜態)
		//創建物件的時候創建匿名代碼塊，而且在建構子之前
		
		System.out.println("匿名代碼塊");
	}
	
	//1.
	static {
		//靜態代碼塊，加載一些初始化的東西
		//類一加載，就直接執行靜態代碼塊，只執行一次
		
		System.out.println("靜態代碼塊");
	}
	
	//3.
	public Person() {
		System.out.println("建構方法");
	
	}
	
	public static void main(String[] args) {
		Person person1 = new Person();
		System.out.println("===============");
		Person person2 = new Person();
		
		
		
	}
}

package com.oop.demo04;

//類
public class Student {

	//屬性私有
	private	String name;  //名字
	private int id;       //學號
	private char gender;  //性別
	private int age;

	//提供一些可以操作這個屬性的方法
	//提供一些public的get、set方法
	
	//get 獲得這個屬性
	public String getName() {
		return this.name;
	}
	
	//set 給這個數據設置值
	public void setName(String name) {
		this.name = name;
	}

	//自動生成get/set ->右鍵->Source
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>120 || age<0) {
			this.age = 3;
		}else {		
		this.age = age;
		}
	}
	
	
	
}

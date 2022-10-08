package com.oop.demo02;

//學生類
public class Student {
	
	//屬性: 字段
	String name;  //null
	int age;      //0
	
	//方法
	public void study() {
		System.out.println(this.name +"在學習");
	}
	
	
}

/* 以下是 main方法 裡測試用的代碼
 
        //類:抽象的，要實例化
		//類實例化後會回傳一個自己的物件
		//student物件就是一個Student類的具體實例

		Student xiaoming = new Student();
		Student xh = new Student();

		xiaoming.name = "小明";
		xiaoming.age = 3;
		
		System.out.println(xiaoming.name);
		System.out.println(xiaoming.age);
		
		
		xh.name = "小紅";
		xh.age = 3;
		System.out.println(xh.name);
		System.out.println(xh.age);
 
 */

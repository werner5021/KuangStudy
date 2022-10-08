package com.oop.demo02;

//一個項目應該只存在一個main方法
public class Application {

	public static void main(String[] args) {

		// new 實例化了一個對象
		Person person = new Person("IU");

		System.out.println(person.name); // null

		/* ====================================== */
		// 類:抽象的，要實例化
		// 類實例化後會回傳一個自己的物件
		// student物件就是一個Student類的具體實例

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

	}

}

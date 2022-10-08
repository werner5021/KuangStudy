package com.oop.demo01;

public class Demo02 {

	public static void main(String[] args) {

		// Student.say(); //非靜態方法不能直接用類別呼叫，要先實體化
		Student.say2(); // 靜態方法可以直接類別呼叫

		// 實體化這個類別 new
		// 物件類型 物件名 = 物件值;
		Student student = new Student();
		student.say();
	}

	// a 和類別一起加載
	public static void a() {
		// b();
	}

	// b 類實體化之後才存在
	public void b() {
		a();
	}
	// 當a、b都為靜態時，可以直接呼叫
	// 當a、b都為非靜態時，可以直接呼叫
	// 當a是靜態一個，b是非靜態時，a不能直接呼叫b，b可以直接呼叫a

}

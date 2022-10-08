package com.oop.demo07;

//static: 
public class Student {

	private static int age; // 靜態變量
	private double score; // 非靜態變量

	public void run() {
		go(); // 非靜態方法可以直接呼叫靜態方法裡的所有東西
	}

	public static void go() {

	}

	public static void main(String[] args) {
		Student s1 = new Student();

		System.out.println(Student.age); // 類變量，如果是靜態變量建議用類別呼叫，讓人知道它是靜態變量，在記憶體中只有一個，能被類中的所有的物件共享
		// System.out.println(Student.score); //非靜態變量不能直接用類別呼叫
		System.out.println(s1.age);
		System.out.println(s1.score);

		// run(); //沒有實體，不能直接呼叫
		new Student().run(); // 必須先new實體，才能用非靜態的方法
		go(); // 因為在類中，可以直接呼叫靜態方法
		Student.go();

	}

}

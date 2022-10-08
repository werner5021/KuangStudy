package com.oop.demo04;

/*
 封裝的意義:
 1. 提高程序的安全性，保護數據
 2. 隱藏代碼的實現細節
 3. 統一介面
 4. 提高系統的可維護性
 */

public class Application {

	public static void main(String[] args) {
		Student s1 = new Student();
		
		s1.setName("IU");
		String name = s1.getName();
		
		System.out.println(name);
		
		s1.setAge(28);  //不合法的數據，可以在封裝的地方檢查
		System.out.println(s1.getAge());
	}

}

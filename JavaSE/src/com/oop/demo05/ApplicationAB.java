package com.oop.demo05;

//重寫
public class ApplicationAB {

	//靜態方法跟非靜態方法區別很大
	public static void main(String[] args) {
		
	//靜態方法: 方法的呼叫只和左邊(定義的數據類型)有關
		A a = new A();
		a.test();   //走A類的方法
		
		//父類的引用(參照)指向了子類
		B b = new A();
		b.test();   //走B類的方法
		
		System.out.println("===============");
		
	//非靜態方法: 重寫	
		A a1 = new A();
		a1.test1();
		
		//父類的引用(參照)指向了子類
		B b1 = new A();  //子類重寫了父類的方法
		b1.test1();
	
	}
}

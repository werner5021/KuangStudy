package com.werner.reflection;

public class Test05 {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(A.m);
		
		/*
		   1.加載到記憶體，會產生一個對應Class的對象
		   2.鏈接，鏈接結束後 m=0
		   3.初始化，<clinit>()方法會合併執行代碼
		  		<clinit>(){
		 				System.out.println("A類靜態代碼初始化");
						m = 300;
						m = 100;
		  		}		  		
		  		m = 100
		 */
	}
}

class A{
	static {
		System.out.println("A類靜態代碼初始化");
		m = 300;
	}
	
	/*
	 * m = 300
	 * m = 100
	 */
	
	
	static int m = 100;
	
	public A() {
		 System.out.println("A類的無參構造初始化");
	}
	
	
}
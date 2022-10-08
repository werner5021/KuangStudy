package com.werner.reflection;

//測試類甚麼時候會初始化
public class Test06 {
	
	static {
		System.out.println("main類被加載");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		//會產生類的引用 (比較消耗資源)
		//1.主動引用
		Son son = new Son();  //main、父、子 
		
		//2.反射也會產生主動引用
//		Class.forName("com.werner.reflection.Son");   //main、父、子
		
		
		//不會產生類的引用的方法
		//1.訪問靜態域，通過子類引用父類的靜態變量，子類不會被加載
//		System.out.println(Son.b);  //main、父
		
		//2.通過陣列定義類引用，不會加載類
//		Son[] array = new Son[5];  //main
		
		//3.調用常量池的常量
//		System.out.println(Son.M);  //main
		
	}
}

class Father{
	
	static int b = 2;
	
	static {
		System.out.println("父類被加載");
	}	
}

class Son extends Father{
	
	static {
		System.out.println("子類被加載");
		m = 300;
	}
	
	static int m = 100;
	static final int M = 1;
	
}
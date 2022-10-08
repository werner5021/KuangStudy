package com.werner.method;

public class Demo01 {
	public static void main(String[] args) {
	
		//實際參數:實際調用傳遞方法的參數
		int sum = add(1, 2);
		System.out.println(sum);
	}
	
	//加法
	//形式參數:用來定義的
	public static int add(int x, int y) {
		return x+y;		
	}
	
}

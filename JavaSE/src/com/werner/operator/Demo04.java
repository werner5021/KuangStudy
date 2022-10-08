package com.werner.operator;

public class Demo04 {

	public static void main(String[] args) {
		//++自增 --自減  一元運算子
		int a = 3;
		
		int b = a++;  // a++  a = a+1  執行完代碼，先賦值給b，再自增
		
		System.out.println(a);
		
		int c = ++a;  // a++  a = a+1  執行代碼前，先自增，再賦值給c
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println("=======");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		//冪運算 2^3  2*2*2=8
		double pow = Math.pow(2,3); 
		System.out.println(pow);

	}

}

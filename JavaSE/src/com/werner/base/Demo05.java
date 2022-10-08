package com.werner.base;

public class Demo05 {

	public static void main(String[] args) {
		int i = 128;
		byte b = (byte) i ;  //內存溢出
		
		int i2 = 128;
		double b2 = i2;
		
		//強制轉換  (類型)變數名   高->低
		//自動轉換              低->高
		
		System.out.println(i);
		System.out.println(b);
		System.out.println(i2);
		System.out.println(b2);
		
		/*
		 * 注意點:
		 * 1. 不能對 boolean 轉換
		 * 2. 不能把對象轉換為不相關的類型
		 * 3. 在高容量轉到低容量的時候，強制轉換
		 * 4. 轉換的時候可能存在內存溢出，精度問題
		 */
		
		System.out.println("===============");
		System.out.println((int)23.7);       // 23
		System.out.println((int)-45.89f);    // -45
		
		System.out.println("===============");
		char c = 'c';
		int d = c+1;
		System.out.println(d);
		System.out.println((char)d);
	}

}

package com.werner.base;

public class Demo06 {

	public static void main(String[] args) {
		// 操作比較大樹的時候，注意溢出問題
		// JDK7新特性，數字之間可以用底線分割
		int money = 10_0000_0000;
		int years = 20;
		int total = money * years;    // -1474836480，計算的時候溢出了
		long total2 = money * years;  // -1474836480，計算的時候溢出了
		System.out.println(total);
		System.out.println(total2);   // 默認是int，轉換之前已經存在問題
		
		long total3 = money*((long)years);  // 先把一個數轉換為long
		System.out.println(total3);
	}

}

package com.werner.array;

public class ArrayDemo02 {
	public static void main(String[] args) {
		//靜態初始化: 創建 + 賦值
		int[] a = {1,2,3,4,5,6,7,8};		
		System.out.println(a[0]);
		
		
		for(int i =0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		//索引值超出，報錯
		for(int i =0; i<=a.length; i++) {
			System.out.println(a[i]);
		}
		
		
		//動態初始化: 包含默認初始化
		int[] b = new int[10];
		b[0] = 10;
		System.out.println(b[0]);
		System.out.println(b[1]);
	}
}

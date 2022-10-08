package com.oop.demo01;

public class Demo03 {
	public static void main(String[] args) {
		//實際參數和型式參數的類型要對應
		int add = Demo03.add(1, 2);
		System.out.println(add);
	}
	
	public static int add(int a, int b) {
		return a+b;
	}
}

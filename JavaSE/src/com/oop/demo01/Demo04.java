package com.oop.demo01;

//值傳遞
public class Demo04 {

	public static void main(String[] args) {
		int a = 1;  //1
		System.out.println(a);  //1
		
		Demo04.change(a);       //在change裡面跑完a=10，但沒回傳數值，回來main時a還是為1
		System.out.println(a);  //1

	}
	
	//回傳值為空
	public static void change(int a) {
		a = 10;
	}

}

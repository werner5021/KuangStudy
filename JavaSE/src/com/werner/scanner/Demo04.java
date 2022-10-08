package com.werner.scanner;

import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		//從鍵盤接收數據
		int i = 0;
		float f = 0.0f;
		
		System.out.println("請輸入整數: ");
		
		if(scn.hasNextInt()) {
			i = scn.nextInt();
			System.out.println("整數數據: " + i);
		}else {
			System.out.println("輸入的不是整數!");
		}
		
		
		System.out.println("請輸入浮點數: ");
		
		if(scn.hasNextFloat()) {
			f = scn.nextFloat();
			System.out.println("浮點數數據: " + f);
		}else {
			System.out.println("輸入的不是浮點數!");
		}
		
		
		scn.close();		
	}
}

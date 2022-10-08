package com.werner.scanner;

import java.util.Scanner;

public class Demo05 {
	public static void main(String[] args) {
		
		//輸入多個數字，求其總和與平均數，每輸入一個數字用Enter，通過輸入非數字來結束輸入，並輸出執行結果
		Scanner scn = new Scanner(System.in);
		
		double total = 0.0;  //總和
		int m = 0;           //次數
		
		System.out.println("請輸入數據: ");
		
		//通過循環判斷是否還有輸入，並且在裡面進行求和、統計
		while(scn.hasNextDouble()) {
			double x = scn.nextDouble();
			total += x;
			m +=1;      //m++
		}
		
		System.out.println(m + "個數的總合為:" + total);
		System.out.println(m + "個數的平均數為:" + (total / m));
		
		scn.close();
	}
}

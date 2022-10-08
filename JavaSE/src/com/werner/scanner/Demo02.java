package com.werner.scanner;

import java.util.Scanner;

public class Demo02 {

	public static void main(String[] args) {
		//創建一個掃描器對象，用來接收鍵盤數據
		Scanner scn = new Scanner(System.in);
		
		System.out.println("使用nextLine接收方式:");
		
		//判斷是否還有輸入
		if(scn.hasNextLine()) {			
			String str = scn.nextLine();
			System.out.println("輸出的內容為:" + str);
		}
			
		scn.close();

	}

}

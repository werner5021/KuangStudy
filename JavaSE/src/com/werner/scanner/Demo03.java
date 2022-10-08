package com.werner.scanner;

import java.util.Scanner;

public class Demo03 {

	public static void main(String[] args) {
		//創建一個掃描器對象，用來接收鍵盤數據
		Scanner scn = new Scanner(System.in);

		System.out.println("請輸入數據:");

		String str = scn.nextLine();
		System.out.println("輸出內容為: "+ str);
		
		scn.close();

	}

}

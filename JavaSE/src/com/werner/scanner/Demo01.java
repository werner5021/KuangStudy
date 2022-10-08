package com.werner.scanner;

import java.util.Scanner;

public class Demo01 {

	public static void main(String[] args) {
		
		//創建一個掃描器對象，用來接收鍵盤數據
		Scanner scn = new Scanner(System.in);
		
		System.out.println("使用next方式接收:");
		
		//判斷使用者有無輸入字串
		if(scn.hasNext()) {
			//使用next方式接收
			String str = scn.next();
			System.out.println("輸出的內容為:" + str);
		}
		
		//凡是屬於IO類的如果不關閉會一直占用資源，要養成好習慣，用完就關掉
		scn.close();
		

	}

}

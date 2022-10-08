package com.werner.structure;

import java.util.Scanner;

public class IfDemo01 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("請輸入內容: ");
		String s = scn.nextLine();
		
		//判斷字串是否相等
		if (s.equals("Hello")) {
			System.out.println(s);
		}
		System.out.println("End");
		
		scn.close();
	}
}

package com.werner.structure;

import java.util.Scanner;

public class IfDemo03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		/*
		 * if 語句最多只有一個else，且else在所有else if 之後
		 * if 語句可以有多個 else if，
		 * 只要有一個else if為true，其他的else if跟else都跳過執行 
		 */
		
		System.out.println("請輸入分數:");
		int score = scn.nextInt();
		
		if(score == 100) {
			System.out.println("滿分");
		}else if(score < 100 && score >= 90) {
			System.out.println("A");
		}else if(score < 90 && score >= 80) {
			System.out.println("B");
		}else if(score < 80 && score >= 70) {
			System.out.println("C");
		}else if(score < 70 && score >= 60) {
			System.out.println("D");
		}else if(score < 60 && score >= 0) {
			System.out.println("F");
		}
		else {
			System.out.println("成績不合法");
		}		
		
		scn.close(); 
	}
}

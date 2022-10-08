package com.werner.structure;

import java.util.Scanner;

public class IfDemo02 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("請輸入分數:");
		int score = scn.nextInt();
		
		if(score >= 60) {
			System.out.println("及格");
		}else {
			System.out.println("不及格");
		}		
		
		scn.close();
	}
}

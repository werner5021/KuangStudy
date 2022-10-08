package com.werner.structure;

import java.util.Iterator;

public class ForDemo02 {
	public static void main(String[] args) {
		//練習1:計算0到100之間的奇數和偶數的和
		
		int oddSum = 0;
		int evenSum = 0;
		
		for(int i=0;i<=100;i++) {
			if( i%2 != 0) {
				oddSum += i;
			}else {
				evenSum +=i;
			}
		}
		
		System.out.println("奇數的和:" + oddSum);
		System.out.println("偶數的和:" + evenSum);

	}
}

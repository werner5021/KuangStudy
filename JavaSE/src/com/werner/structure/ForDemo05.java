package com.werner.structure;

public class ForDemo05 {
	public static void main(String[] args) {
		int[] numbers = {10,20,30,40,50};  //定義陣列
		
		//歷遍陣列中的元素
		for(int x :numbers) {
			System.out.println(x);
		}
		
		for(int i=0; i<5; i++) {
			System.out.println(numbers[i]);
		}
		
	}
}

package com.werner.structure;

public class WhileDemo03 {
	public static void main(String[] args) {
		
		//計算1+2+3+...+100=?
		int i = 1;
		int sum = 0;
		
		while(i<=100) {
			sum += i;
			i++;
		}
		
		System.out.println(sum);
	}
}

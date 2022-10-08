package com.werner.structure;

public class ForDemo04 {

	public static void main(String[] args) {
		//輸出九九乘法表
		
		//1.輸出第一列
		//2.把固定的1再開一個循環包起來
		//3.去掉重複，j<=i
		//4.調整樣式
		
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j + "*" + i + "=" + i*j + "\t" );
				}
			System.out.println();
			}
		}
		
		/*
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.print(i + "*" + j + "=" + i*j + "\t" );
				if(j == 9) {
					System.out.println();
				}
			}
			
		}
		*/		

	

}

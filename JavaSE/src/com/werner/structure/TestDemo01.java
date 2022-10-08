package com.werner.structure;

public class TestDemo01 {

	public static void main(String[] args) {
		//印出三角形 5行
		
		
		/*
		for(int i=1; i<=5; i++) {
			
			for(int k=5;k>i;k--) {
				System.out.print(" ");				
			}
			for(int j=1;j<=2*i-1;j++) {
				System.out.print("*");				
			}
			System.out.print("\n");
		}
		*/
		for(int i=1; i<=5;i++) {
			for(int j=5; j>=i; j--) {
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			for(int j=1; j<i;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
		

	}

}

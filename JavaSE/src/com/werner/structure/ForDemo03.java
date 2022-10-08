package com.werner.structure;

public class ForDemo03 {
	public static void main(String[] args) {
		
		//用while或for循環輸出1-1000之間能被5整除的樹，並且每行輸出3個
		
		for(int i=0; i<=1000;i++) {
			if(i%5 == 0) {
				System.out.print(i+"\t");
			}
			if(i%(5*3) == 0) {
				System.out.print("\n");
				//System.out.println();
			}
			
		}
		
		//println 輸出會換行
		//print   輸出不換行
		
		
		
		
//		for(int i=5; i <=1000; i+=5) {
//
//			System.out.print(i+", ");
//			if(i%3==0) 
//				System.out.println();			
//		}
	}
}

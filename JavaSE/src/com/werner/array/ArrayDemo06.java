package com.werner.array;

import java.util.Arrays;

public class ArrayDemo06 {
	public static void main(String[] args) {
		
		int[] a= {1,2,3,4,9999,1620,3333,5};
		
		System.out.println(a);  //[I@123a439b
		
		//印出陣列元素
		System.out.println(Arrays.toString(a));
		//也可以自定義方法印出
		printArray(a);		
		System.out.println("\n=====================");
		
		Arrays.sort(a);  //陣列排序: 升序
		System.out.println(Arrays.toString(a));
		
//		Arrays.fill(a, 0);
//		System.out.println(Arrays.toString(a));
				
		Arrays.fill(a, 2, 4, 0);
		System.out.println(Arrays.toString(a));
		
		
		System.out.println(Arrays.binarySearch(a, 0,2,1620));
		System.out.println(Arrays.binarySearch(a, 9999));
		System.out.println(Arrays.binarySearch(a, 5));
	}
	
	//重複造輪子
	public static void printArray(int[] a) {
		for(int i=0; i<a.length; i++) {
			if(i==0) {
				System.out.print("[");
			}						
			if(i==a.length-1) {
				System.out.print(a[i]+"]");
			}else {
				System.out.print(a[i]+", ");
			}
		}
	}
	
	
	
	
}

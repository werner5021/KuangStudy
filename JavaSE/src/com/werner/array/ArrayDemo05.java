package com.werner.array;

public class ArrayDemo05 {
	public static void main(String[] args) {
		
		//[4][2]
		/*
			1,2  array[0]
			2,3  array[1]
			3,4  array[2]
			4,5  array[3]
		 */
		int[][] array = {{1,2},{2,3},{3,4},{4,5}};
		
		System.out.println(array[0]);  //只能看到記憶體位置
		printArray(array[0]);
		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		
		System.out.println(array.length);
		System.out.println(array[0].length);
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				System.out.println(array[i][j]);
			}
			
		}
		
	}
	
	//印出陣列元素
		public static void printArray(int[] arrays) {
			for(int i=0; i<arrays.length; i++) {
				System.out.print(arrays[i]+" ");
			}
		}
	
	
}

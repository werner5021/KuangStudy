package com.werner.array;

import java.util.Arrays;

public class ArrayDemo07 {

	public static void main(String[] args) {
		int[] a = { 1, 6, 19, 56, 33, 4, 8, 3, 2 };

		int[] b = sort(a); // 呼叫自己做的排序的陣列
		System.out.println(Arrays.toString(b));
	}

	// 氣泡排序法
	// 1. 比較陣列中相鄰的兩個元素，如果第一個比第二個大，交換位置
	// 2. 每一次比較，都會產生一個最大或最小的數字
	// 3. 下一輪可以少一次排序
	// 4. 依次循環直到結束

	public static int[] sort(int[] array) {
		// 臨時變量
		int temp = 0;

		// 外層循環，判斷循環要走多少次
		for (int i = 0; i < array.length; i++) {

			boolean flag = false; // 通過flag，減少沒有意義的比較

			// 內層循環，比較兩個數，如果第一個比第二個大，交換位置
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
					flag = true;
				}

				if (flag == false) { // 如果這一輪沒有比較，flag就不會為true，直接跳出循環
					break;
				}

			}
		}

//		for(int i=0; i<array.length-1; i++) {
//			
//			//內層循環，比較兩個數，如果第一個比第二個大，交換位置
//			for(int j=0; j<array.length-1-i; j++) {
//				if(array[j+1]>array[j]) {
//					temp = array[j];
//					array[j] = array[j+1];
//					array[j+1] = temp;
//				}				
//			}			
//		}	

		return array;
	}
}

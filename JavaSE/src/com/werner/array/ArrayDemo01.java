package com.werner.array;

public class ArrayDemo01 {
	// 變量的類型  變量的名字 = 變量的值
	public static void main(String[] args) {
				
		// int nums2[]; //早年讓C、C++的工程師快速上手用的
		
		int[] nums; //1.宣告陣列		
		nums = new int[10];  // 2.創建陣列

		//3.賦值給陣列元素
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 4;
		nums[4] = 5;
		nums[5] = 6;
		nums[6] = 7;
		nums[7] = 8;
		nums[8] = 9;
		nums[9] = 10;
		
		System.out.println(nums[9]);
		
		//計算所有元素和
		int sum = 0;
		//獲取陣列長度: arrays.lenth
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
		}
		
//		for(int x :nums) {
//			sum += x;
//		}
		System.out.println(sum);
	}

}

package com.werner.array;

public class ArrayTest {
	public static void main(String[] args) {

		// 1.創建一般陣列
		int[][] array1 = new int[11][11];

		array1[1][2] = 1;
		array1[2][3] = 2;

		for (int[] int1 : array1) {
			for (int int2 : int1) {
				System.out.print(int2 + " ");
			}
			System.out.println();
		}

		// 2.有效個數
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (array1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("有效個數:" + sum);

		// 3.用有效個數建稀疏陣列，並歷遍array1把有效值取出帶入稀疏陣列
		int[][] array2 = new int[sum + 1][3];

		array2[0][0] = 11; // 列
		array2[0][1] = 11; // 欄
		array2[0][2] = sum; // 有效個數

		int count = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++) {
				if (array1[i][j] != 0) {
					count++;
					array2[count][0] = i;
					array2[count][1] = j;
					array2[count][2] = array1[i][j];
				}
			}
		}

		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i][0] + " " + array2[i][1] + " " + array2[i][2]);
		}

		System.out.println("還原");

	}
}

package com.werner.array;

public class ArrayDemo08 {

	public static void main(String[] args) {
		// 1.創建一個二維陣列 11*11 0:空白 1:黑棋 2:白棋
		int[][] array1 = new int[11][11];
		array1[1][2] = 1;
		array1[2][3] = 2;

		// 輸出原始陣列
		System.out.println("輸出原始陣列");

		for (int[] ints : array1) {
			for (int anInt : ints) {
				System.out.print(anInt + "\t");
			}
			System.out.println();
		}

		System.out.println("=====================");

		// 轉換為稀疏陣列來保存
		// 獲取有效值的個數
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (array1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("有效個數為:" + sum);

		// 2.創建一個稀疏陣列
		int[][] array2 = new int[sum + 1][3];

		array2[0][0] = 11; // 列
		array2[0][1] = 11; // 欄
		array2[0][2] = sum; // 有效個數

		// 歷遍二維陣列，將非0的值存放到稀疏陣列中
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

		// 輸出稀疏陣列
		System.out.println("稀疏陣列");

		for (int i = 0; i < array2.length; i++) {
			System.out.println(array2[i][0] + "\t" + array2[i][1] + "\t" + array2[i][2] + "\t");
		}

		System.out.println("=====================");
		System.out.println("還原");

		// 1.讀取稀疏陣列
		int[][] array3 = new int[array2[0][0]][array2[0][1]];

		// 2.給其中的元素還原他的值
		for (int i = 1; i < array2.length; i++) {
			array3[array2[i][0]][array2[i][1]] = array2[i][2];
		}

		// 3.印出
		System.out.println("輸出還原陣列");

		for (int[] ints : array3) {
			for (int anInt : ints) {
				System.out.print(anInt + "\t");
			}
			System.out.println();
		}

	}

}

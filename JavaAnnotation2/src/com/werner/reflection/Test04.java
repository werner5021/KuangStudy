package com.werner.reflection;

import java.lang.annotation.ElementType;

//所有類型的class
public class Test04 {
	
	public static void main(String[] args) {
		Class c1 = Object.class;  //類
		Class c2 = Comparable.class;  //介面
		Class c3 = String[].class;  //一維陣列
		Class c4 = int[][].class;  //二維陣列
		Class c5 = Override.class;  //註解
		Class c6 = ElementType.class;  //枚舉
		Class c7 = Integer.class;  //基本型別
		Class c8 = void.class;  //void類型
		Class c9 = Class.class;  //Class
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
		System.out.println(c8);
		System.out.println(c9);
		
		//只要元素類型與維度一樣，就是同一個Class
		//輸出結果相同 → 兩個長度不一樣的陣列，只要類型一樣，Class類就一定一樣
		int[] a = new int[10];
		int[] b = new int[100];		
		System.out.println(a.getClass().hashCode());
		System.out.println(b.getClass().hashCode());
		
	}
	
}

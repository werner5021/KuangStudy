package com.werner.operator;

public class Demo05 {

	//邏輯運算子
	public static void main(String[] args) {
		// and or not
		boolean a = true;
		boolean b = false;
		
		System.out.println("a && b: " + (a && b));
		System.out.println("a || b: " + (a || b));
		System.out.println("!(a && b): "+ !(a && b));
		
		//短路運算
		int c = 5;
		boolean d = (c<4) && (c++<4);
		System.out.println(d);
		System.out.println(c);

	}
}

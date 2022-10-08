package com.werner.operator;

public class Demo07 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		a += b ;  //a = a+b
		a -= b ;  //a = ab
		
		System.out.println(a);

		//字串連接符，只要有String，全都會變成字串連接
		System.out.println(a+b);
		System.out.println(""+a+b);
		System.out.println(a+b+"");
	}

}

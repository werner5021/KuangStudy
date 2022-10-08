package com.werner.operator;

//三元運算符
public class Demo08 {

	public static void main(String[] args) {
		// x ? y : z
		//如果x == true，則結果為y，否則為z
		
		int score = 50;
		
		String type = score < 60 ? "不及格": "及格";  //必須掌握

		System.out.println(type);
	}

}

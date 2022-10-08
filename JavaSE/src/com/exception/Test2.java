package com.exception;

public class Test2 {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		
		
		//Alt + Shift + z 或是右鍵
		try {	
			System.out.println(a/b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  //印出錯誤的Stack訊息
		}
	}
	
	public void test(int a, int b) {
		
	}
	
	
	
}

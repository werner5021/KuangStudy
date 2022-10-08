package com.exception;

public class Test3 {
	public static void main(String[] args) {

		try {
			new Test3().test(1, 0);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 假設這個方法中處理不了異常，在方法上拋出異常
	public void test(int a, int b) throws ArithmeticException { // 在方法上用throws
		if (b == 0) { // throw thorws
			throw new ArithmeticException(); // 主動拋出異常，一般在方法中使用，在方法裡用throw
		}
		System.out.println(a / b);

	}

}

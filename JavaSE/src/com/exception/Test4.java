package com.exception;

public class Test4 {

	// 可能會存在異常的方法

	static void test(int a) throws MyException {

		System.out.println("你傳遞的參數為: " + a);

		if (a > 10) {
			throw new MyException(a); // 拋出
		}

		System.out.println("OK");
	}

	public static void main(String[] args) {
		try {
			test(11);
		} catch (MyException e) {
			// 增加一些處理異常的代碼塊
			System.out.println("MyException->" + e);
		}

	}

}

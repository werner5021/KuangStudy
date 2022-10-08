package com.exception;

//自定義異常
public class MyException extends Exception {

	// 傳遞數字>10
	private int detail;

	// 建構子，接收參數，用系統自動建立
	public MyException(int a) {
		this.detail = a;
	}

	// toString: 異常的輸出訊息，用系統自動建立
	@Override
	public String toString() {
		// return "MyException{"+ detail +"}";
		return super.toString();
	}

}

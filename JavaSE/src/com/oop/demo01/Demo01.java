package com.oop.demo01;

import java.io.IOException;

// Demo01 類別
public class Demo01 {

	// main 方法 (用來啟動程序的)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	  修飾符  回傳值類型  方法名(...){
	     // 方法體
	     return 回傳值;
	  }
	 */
	//return 結束方法，回傳一個結果
	public String sayhello() {
		return "hello, world";
	}
	
	public void hello() {
		return ;
	}
	
	public int max(int a, int b) {
		return a>b?a:b;   //三元運算
	}
	
	public void readFile(String file) throws IOException{
		
	}
	

}

package com.werner.demo01;

//創建線程方式一: 繼承thread類，重寫run()方法，呼叫start開啟線程

//總結: 注意，線程開啟不一定要立即執行，由CPU調度

public class TestThread1 extends Thread {

	@Override
	public void run() {
		//run方法線程體
		for(int i=0; i<20; i++) {
			System.out.println("我在看代碼---"+i);
		}
	}
	
	public static void main(String[] args) {
		//main線程，主線程
		
		//創建一個線程物件
		TestThread1 testThread1 = new TestThread1();
		
		//呼叫start()方法開啟線程
		testThread1.start();
		
		
		for(int i=0; i<20; i++) {
			System.out.println("我在看學習多線程---"+i);
		}
	}
	
	
	
}

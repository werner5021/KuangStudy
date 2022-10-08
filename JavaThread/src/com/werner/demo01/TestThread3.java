package com.werner.demo01;

//創建線程方式二: 實現runnable方法，重寫run()方法，執行線程需要丟入runnable介面實現類，呼叫start()方法
public class TestThread3 implements Runnable {
	
	//run方法線程體
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println("我在看代碼"+i);
		}
		
	}
	
	public static void main(String[] args) {
		
		//創建runnable介面的實現類
		TestThread3 testThread3 = new TestThread3();
		
		//創建線程物件，通過線程物件來開啟我們的線程，代理
//		Thread thread = new Thread(testThread3);
//		thread.start();  //兩行能結合成下面那一行
		
		new Thread(testThread3).start();
		
		
		for(int i=0; i<50; i++) {
			System.out.println("我在學習多線程"+i);
		}
	}
	
	
	
	
}

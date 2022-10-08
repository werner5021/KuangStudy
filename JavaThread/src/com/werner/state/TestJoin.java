package com.werner.state;

//測試join方法，插隊
public class TestJoin implements Runnable {	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("線程VIP來了"+i);
		}		
	}

	public static void main(String[] args) throws InterruptedException {
		//啟動分支線程
		TestJoin testJoin = new TestJoin();		
		Thread thread = new Thread(testJoin);
		thread.start();
		
		//主線程
		for(int i=0;i<500;i++) {
			if(i==200) {
				thread.join();
			}
			System.out.println("main  "+i);
		}		
	}
}


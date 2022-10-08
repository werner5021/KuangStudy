package com.werner.state;

//測試禮讓線程
//禮讓不一定成功
public class TestYield {
	public static void main(String[] args) {
		MyYield myYield = new MyYield();
		
		new Thread(myYield,"a").start();
		new Thread(myYield,"b").start();
	}
}

class MyYield implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"線程開始執行");
		Thread.yield();  //禮讓
		System.out.println(Thread.currentThread().getName()+"線程停止執行");
	}	
}

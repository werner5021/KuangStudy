package com.werner.advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//測試線程池
public class TestPool {
	public static void main(String[] args) {
		//1.創建線程池
		//newFixedThreadPool 參數為線程池大小
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		//2.執行 Runnable接口的實現
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		service.execute(new MyThread());
		
		//3.關閉連接
		service.shutdown();
		
		
	}
	
}	

class MyThread implements Runnable{

	@Override
	public void run() {		
			System.out.println(Thread.currentThread().getName());		
	}
	
}
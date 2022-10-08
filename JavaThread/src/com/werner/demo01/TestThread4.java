package com.werner.demo01;

//多個線程同時操作同一個物件
//買火車票

//多個線程操作同一個資源的情況下，線程不安全，數據混亂
public class TestThread4 implements Runnable {
	
	//票數
	private int ticketNums = 50;
	
	
	@Override
	public void run() {
		while(true) {
			if(ticketNums<=0) break;
			
			//模擬延遲
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			
			System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"票");
		}
	}	
	
	public static void main(String[] args) {
		//只需要一個物件，不用三個
		TestThread4 ticket = new TestThread4();
		//開啟三個線程
		new Thread(ticket,"小明").start();
		new Thread(ticket,"老師").start();
		new Thread(ticket,"黃牛黨").start();		
	}
}

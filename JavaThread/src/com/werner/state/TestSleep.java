package com.werner.state;

import com.werner.demo01.TestThread4;

//模擬網路延遲: 放大問題的發生性
public class TestSleep implements Runnable{
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
			TestSleep ticket = new TestSleep();
			//開啟三個線程
			new Thread(ticket,"小明").start();
			new Thread(ticket,"老師").start();
			new Thread(ticket,"黃牛黨").start();		
		}
}

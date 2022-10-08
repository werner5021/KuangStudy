package com.werner.state;

//測試線程優先級
public class TestPriority {
	
	public static void main(String[] args) {
		//主線程默認優先級
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		
		MyPriority myPriority = new MyPriority();
		Thread t1 = new Thread(myPriority);
		Thread t2 = new Thread(myPriority);
		Thread t3 = new Thread(myPriority);
		Thread t4 = new Thread(myPriority);
		Thread t5 = new Thread(myPriority);
		Thread t6 = new Thread(myPriority);
		
		//先設置優先級，再啟動
		t1.start();
		
		t2.setPriority(1);
		t2.start();
		
		t3.setPriority(4);
		t3.start();
		
		t4.setPriority(Thread.MAX_PRIORITY);  //MAX_PRIORITY=10;
		t4.start();
		
		t5.setPriority(8);
		t5.start();
		
		t6.setPriority(6);
		t6.start();
		
		/* 超過範圍會報錯
		t5.setPriority(-1);
		t5.start();
		
		t6.setPriority(11);
		t6.start();
		*/
	}
}

class MyPriority implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
	}
}

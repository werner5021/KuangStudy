package com.werner.state;

//測試stop
//1.建議線程正常停止 --> 利用次數，不建議死循環
//2.建議使用標誌位 --> 設置一個標誌位
//3.不建議使用stop或destroy等過時，或JDK不建議使用的方法
public class TestStop implements Runnable{

	//1.設置一個標識位
	private boolean flag = true;
	
	
	public void run() {
		int i = 0;
		while(flag) {
			System.out.println("run...Thread" + i++);;
		}		
	}

	//2.設置一個公開的方法停止線程，轉換標誌位
	public void stop() {
		this.flag = false;
	}
	
	
	public static void main(String[] args) {
		TestStop teststop = new TestStop();
		
		new Thread(teststop).start();
		
		for(int i=0;i<1000;i++) {
			System.out.println("main"+i);
			if(i==900) {
				//呼叫stop()方法切換標誌位，讓線程停止
				teststop.stop();
				System.out.println("線程停止了");
			}
		}
	}
}

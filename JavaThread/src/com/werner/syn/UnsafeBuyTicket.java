package com.werner.syn;

//不安全的買票
//線程不安全，有負數
public class UnsafeBuyTicket {	
	public static void main(String[] args) {
		BuyTicket station = new BuyTicket();
		
		new Thread(station,"苦逼的我").start();
		new Thread(station,"牛逼的你們").start();
		new Thread(station,"可惡的黃牛黨").start();		
	}	
}

class BuyTicket implements Runnable{
	
	//票
	private int ticketNums = 100;
	private boolean flag = true;  //外部停止方式
	
	@Override
	public void run() {
		// 買票
		while(flag){
			 try {
				//模擬延遲
				 Thread.sleep(100);
				buy();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	//synchronized 同步方法，鎖的是this類別本身
	private synchronized void buy() throws InterruptedException {
//	private void buy() throws InterruptedException {
		//判斷是否有票
		if(ticketNums<=0) {
			flag = false;
			return;
		}		
		//模擬延遲
//		Thread.sleep(100);
		//買票
		System.out.println(Thread.currentThread().getName()+"取得第"+ticketNums--+"張票");
	}
	
}



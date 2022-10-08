package com.werner.advanced;

//測試生產消費者問題2:信號燈法
public class TestPC2 {
	public static void main(String[] args) {
		TV tv = new TV();
		new Player(tv).start();
		new Watcher(tv).start();		
	}
}

//生產者-->演員
class Player extends Thread{
	TV tv;	
	public Player(TV tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			if(i%2==0) {
				this.tv.player("快樂大本營播放中");
			}else {
				this.tv.player("抖音");
			}
		}
	}	
}

//消費者-->觀眾
class Watcher extends Thread{
	TV tv;	
	public Watcher(TV tv) {
		this.tv = tv;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			tv.watch();
		}
	}	
}

//產品-->節目
class TV {
	//演員表演，觀眾等待 T
	//觀眾觀看，演員等待 F
	String voice; //表演的節目
	boolean flag = true;
	
	//表演
	public synchronized void player(String voice) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("演員表演了:"+voice);
		//通知觀眾觀看
		this.notifyAll();  //通知喚醒
		this.voice = voice;
		this.flag = !this.flag;
	}	
	
	//觀看
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		System.out.println("觀看了:"+ voice);
		//通知演員表演
		this.notifyAll();
		this.flag = !this.flag;
	}	
}
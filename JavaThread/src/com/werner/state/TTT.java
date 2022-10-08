package com.werner.state;

public class TTT {
	public static void main(String[] args) {
		TV2 tv = new TV2();		
		new Actor(tv).start();
		new Audience(tv).start();
	}
	
}

class Actor extends Thread{
	TV2 tv;	
	public Actor(TV2 tv) {
		this.tv = tv;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			if(i%2==0) {
				tv.makeMovie("Running Man 播放中");
			}else {
				tv.makeMovie("驅魔麵館 播放中");
			}
		}
	}
}

class Audience extends Thread{
	TV2 tv;	
	public Audience(TV2 tv) {
		this.tv = tv;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			tv.seeMovie();
		}
	}	
	
}

class TV2{
	//演員表演，觀眾等待 T
	//觀眾觀看，演員等待 F
	String movie;
	boolean flag = true;
	
	//拍片
	public synchronized void makeMovie(String movie) {
		//如果為F，演員等待
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//如果為T，演員拍片
		this.movie = movie;
		System.out.println("演員拍了---"+this.movie);
		this.notifyAll();
		
		this.flag= !this.flag;		
	}
	
	
	//追劇
	public synchronized void seeMovie() {
		//如果為T，觀眾等待
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//如果為F，觀眾觀看
		System.out.println("觀眾看了---"+ movie);
		this.notifyAll();
		this.flag= !this.flag;
	}
}
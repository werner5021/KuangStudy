package com.werner.demo01;

//模擬龜兔賽跑
public class Race implements Runnable {
	
	//3.勝利者
	private static String winner;
	
	//1.重寫run()方法
	@Override
	public void run() {
		for(int i=0; i<=500; i++) {			
			//模擬兔子休息
			if(Thread.currentThread().getName().equals("兔子") && i%10 ==0) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//判斷比賽是否結束
			boolean flag = gameOver(i);
			//如果比賽結束，就停止程序
			if(flag) {
				break;
			}		
			
			System.out.println(Thread.currentThread().getName() + "-->跑了" + i + "步");
		}			
	}
	
	//2.判斷是否完成比賽
	public boolean gameOver(int steps) {
		//判斷是否有勝利者
		if(winner != null) {  // 已經存在勝利者
			return true;
		}else {
			if(steps >= 500) {
				winner = Thread.currentThread().getName();
				System.out.println("winner is "+ winner);
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		Race race = new Race();
		
		new Thread(race,"烏龜").start();
		new Thread(race,"兔子").start();
		
	}
	
	
	
	
	
	
}

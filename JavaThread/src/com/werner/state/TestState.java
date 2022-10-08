package com.werner.state;

//
public class TestState {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()->{
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(500);
					System.out.println("線程運行中"+i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(":::::");			
		});
		
		//觀察狀態
		Thread.State state = thread.getState();
		System.out.println(state);  //NEW
		
		//觀察啟動後
		thread.start();  //啟動線程
		state = thread.getState();
		System.out.println(state);  //RUN
		
		while(state != Thread.State.TERMINATED) {  //只要線程不終止，就一直輸出狀態
			Thread.sleep(500);
			state = thread.getState();  //更新狀態
			System.out.println(state);  //輸出狀態
		}
		
		thread.start();  // 停止過後的線程不能再啟動，報錯
		
		
	}
}

package com.werner.state;

import java.sql.Date;
import java.text.SimpleDateFormat;

//模擬倒計時
public class TestSleep2 {
	//模擬倒計時
	public static void turnDown() throws InterruptedException {
		int num = 10;
		
		while(true) {
			Thread.sleep(1000);
			System.out.println(num--);
			if(num<=0) break;			
		}
	}	
	
	//印出當前系統時間
	public static void main(String[] args) {
		Date startTime = new Date(System.currentTimeMillis());  //獲取系統當前時間
	
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
				startTime = new Date(System.currentTimeMillis());  //更新當前時間
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

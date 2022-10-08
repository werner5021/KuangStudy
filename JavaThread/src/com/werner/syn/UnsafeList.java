package com.werner.syn;

import java.util.ArrayList;
import java.util.List;

//線程不安全的集合
public class UnsafeList {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		for(int i=0; i<10000; i++) {
			new Thread(()->{
				synchronized(list) {
					list.add(Thread.currentThread().getName());
				}					
			}).start();
		}  //兩個線程同一瞬間操作同一個位置，把兩個陣列元素添加到同一位置，有的元素被覆蓋，才會有少
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
}

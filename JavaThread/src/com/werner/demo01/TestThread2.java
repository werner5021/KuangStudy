package com.werner.demo01;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

//練習Thread，實現多現程同步下載
//3.繼承Thread才能實現多線程
public class TestThread2 extends Thread{

	//4.用建構子丟url、name
	private String url;   //網路圖片地址
	private String name;  //保存的文件名
	
	public TestThread2(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	//5.用run方法去執行線程
	//下載圖片線程的執行體
	@Override
	public void run() {
		WebDownloader webDownloader = new WebDownloader();
		webDownloader.downloader(url, name);
		System.out.println("下載的文件名為:"+name);
		
	}
	
	//6.創建與啟動線程
	public static void main(String[] args) {
		TestThread2 t1 = new TestThread2("https://images.chinatimes.com/newsphoto/2022-05-18/1024/20220518001427.jpg","IU.jpg");
		TestThread2 t2 = new TestThread2("https://img.ltn.com.tw/Upload/style/page/2022/04/27/220427-19670-3-oFZPz.jpg","IU2.jpg");
		TestThread2 t3 = new TestThread2("https://img.ltn.com.tw/Upload/style/page/2022/04/27/220427-19670-5-zpNFj.jpg","IU3.jpg");
	
		//程式碼是先下載t1、然後T2、最後T3
		t1.start();
		t2.start();
		t3.start();
		//實際上多線程是由CPU調度分配
	}
	
}

//1.建構下載器
class WebDownloader{
	
	//2.下載方法
	public void downloader(String url, String name) {
		try {
			FileUtils.copyURLToFile(new URL(url),new File(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IO異常，downloader方法出現問題");
		}
	}
}

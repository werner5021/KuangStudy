package com.werner.demo01;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

//練習Thread，實現多現程同步下載
//3.繼承Thread才能實現多線程
public class TestThread3_2 implements Runnable{

	//4.用建構子丟url、name
	private String url;   //網路圖片地址
	private String name;  //保存的文件名
	
	public TestThread3_2(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	//5.用run方法去執行線程
	//下載圖片線程的執行體
	@Override
	public void run() {
		WebDownloader2 webDownloader2 = new WebDownloader2();
		webDownloader2.downloader(url, name);
		System.out.println("下載的文件名為:"+name);
		
	}
	
	//6.創建與啟動線程
	public static void main(String[] args) {
		TestThread3_2 t1 = new TestThread3_2("https://images.chinatimes.com/newsphoto/2022-05-18/1024/20220518001427.jpg","IU.jpg");
		TestThread3_2 t2 = new TestThread3_2("https://img.ltn.com.tw/Upload/style/page/2022/04/27/220427-19670-3-oFZPz.jpg","IU2.jpg");
		TestThread3_2 t3 = new TestThread3_2("https://img.ltn.com.tw/Upload/style/page/2022/04/27/220427-19670-5-zpNFj.jpg","IU3.jpg");
	
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
	}
	
}

//1.建構下載器
class WebDownloader2{
	
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

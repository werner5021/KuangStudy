package com.werner.demo02;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

import com.werner.demo01.TestThread2;

//線程創建方式三:實現callable介面
/*
 callable的好處
 1.可以定義回傳值
 2.可以拋出異常
 */

public class TestCallable implements Callable{
	
	private String url;
	private String name;	
	
	public TestCallable(String url, String name) {
		this.url = url;
		this.name = name;
	}

	public Boolean call() {
		WebDownloader webDownloader = new WebDownloader();
		webDownloader.downloader(url, name);
		System.out.println("下載的文件名為:"+name);
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		TestCallable t1 = new TestCallable("https://images.chinatimes.com/newsphoto/2022-05-18/1024/20220518001427.jpg","IU.jpg");
		TestCallable t2 = new TestCallable("https://img.ltn.com.tw/Upload/style/page/2022/04/27/220427-19670-3-oFZPz.jpg","IU2.jpg");
		TestCallable t3 = new TestCallable("https://img.ltn.com.tw/Upload/style/page/2022/04/27/220427-19670-5-zpNFj.jpg","IU3.jpg");
	
		//創建執行服務
		ExecutorService ser = Executors.newFixedThreadPool(3);
		
		//提交執行
		Future<Boolean> r1 = ser.submit(t1);
		Future<Boolean> r2 = ser.submit(t2);
		Future<Boolean> r3 = ser.submit(t3);
		
		//獲取結果
		 boolean rs1 = r1.get();
		 boolean rs2 = r2.get();
		 boolean rs3 = r3.get();
		 
		 System.out.println(rs1);
		 System.out.println(rs2);
		 System.out.println(rs3);
		
		 //關閉服務
		 ser.shutdownNow();		
	}
}
 
//1.建構下載器
class WebDownloader{
	//2.下載方法
	public void downloader(String url, String name) {		
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
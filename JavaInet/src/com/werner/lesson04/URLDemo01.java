package com.werner.lesson04;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=werner&password=123");
		System.out.println(url.getProtocol());  //得到協議名
		System.out.println(url.getHost());  //得到主機IP
		System.out.println(url.getPort());  //得到port
		System.out.println(url.getPath());  //得到文件的地址
		System.out.println(url.getFile());  //得到文件全路徑
		System.out.println(url.getQuery());  //得到參數
		
	}
}


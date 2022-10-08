package com.werner.chat;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//通過URL下載文件
//D:\3_Tools\WebServer\apache-tomcat-9.0.52\webapps\WERNER_TEST\TestUrlDownLoad.txt
public class URLDown {
	public static void main(String[] args) throws Exception {
		//1.下載地址
		URL url = new URL("http://localhost:8080/WERNER_TEST/TestUrlDownLoad.txt");
//		URL url = new URL("https://i.pinimg.com/564x/88/80/42/88804284a17efb24b1f8493ae40350dd.jpg");

		//2.連接到這個資源 HTTP
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		//網路上一切都是流
		InputStream inputStream = urlConnection.getInputStream();
		
		FileOutputStream fos = new FileOutputStream("測試URL用.txt");
//		FileOutputStream fos = new FileOutputStream("IU桌布.jpg");
		byte[] buffer = new byte[1024];
		int len;
		while((len = inputStream.read(buffer)) != -1) {
			fos.write(buffer, 0, len);  //寫出這個數據
		}
		fos.close();
		inputStream.close();
		urlConnection.disconnect();
	}
}

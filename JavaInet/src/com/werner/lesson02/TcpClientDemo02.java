package com.werner.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo02 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.創建一個Socket連接
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
		//2.創建一個輸出流
		OutputStream os = socket.getOutputStream();
		
		//文件流(把文件變成流，再輸出)
		//3.讀取文件
		FileInputStream fis = new FileInputStream(new File("Jisoo01.jpg"));
		//4.寫出文件
		byte[] buffer = new byte[1024];
		int len;
		while((len=fis.read(buffer)) != -1) {
			os.write(buffer,0,len);
		}
		
		//通知服務器，我已經結束了
		socket.shutdownOutput();  //我已經傳輸完了
		
		//確定服務器接收完畢，才能斷開連接
		InputStream is = socket.getInputStream();
		//String byte[]
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer2 = new byte[1024];
		int len2;
		while((len2=is.read(buffer2)) != -1) {
			baos.write(buffer2,0,len2);
		}
		System.out.println(baos.toString());		
		
		//5.關閉資源
		baos.close();
		is.close();
		fis.close();
		os.close();
		socket.close();
	}
}

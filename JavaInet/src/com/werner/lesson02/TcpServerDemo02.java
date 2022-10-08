package com.werner.lesson02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo02 {
	public static void main(String[] args) throws IOException {
		//1.創建服務
		ServerSocket serverSocket = new ServerSocket(9000);
		//2.監聽客戶端連接
		Socket socket = serverSocket.accept();  //阻塞式監聽，會一直等待客戶端連接
		//3.獲取輸入流
		InputStream is = socket.getInputStream();
		//4.文件輸出
		FileOutputStream fos = new FileOutputStream(new File("收到Jisoo了.jpg"));
		byte[] buffer = new byte[1024];
		int len;
		while((len=is.read(buffer))!= -1) {
			fos.write(buffer,0,len);
		}
				
		//通知客戶端我接收完畢了
		OutputStream os = socket.getOutputStream(); 
		os.write("我接收完畢了，你可以斷開了".getBytes());
		
		//5.關閉資源
		os.close();
		fos.close();
		is.close();
		socket.close();
		serverSocket.close();
	}
}

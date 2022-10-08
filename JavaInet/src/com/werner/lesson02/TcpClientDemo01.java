package com.werner.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客戶端
public class TcpClientDemo01 {
	public static void main(String[] args) {
			Socket socket = null;
			OutputStream os = null;
		
		
		try {
			//1.要知道服務器的地址、port號
			InetAddress serverIP = InetAddress.getByName("127.0.0.1");
			int port = 9999;
			//2.創建一個socket連接
			socket = new Socket(serverIP,port);
			//3.發送消息 IO流
			os = socket.getOutputStream();
			os.write("你好，歡迎學習".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {		
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}				
		}
	}
}

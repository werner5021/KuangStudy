package com.werner.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服務端
public class TcpServerDemo01 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null; 
		
		try {
			//1.我要有一個自己的地址讓客戶端連接
			serverSocket = new ServerSocket(9999);
			//2.等待客戶端連接過來
			socket = serverSocket.accept();  //拿到客戶端的socket
			//3.讀取客戶端的消息
			is= socket.getInputStream();
			
			/*
			 * 這樣的問題在於，如果有中文輸入，超過1024就會斷掉，成為亂碼
			 * byte[] buffer = new byte[1024]; 
			 * int len; 
			 * while((len=is.read(buffer)) != -1) {
			 * String msg = new String(buffer, 0, len);
			 * System.out.println(msg);	
			 * } 
			 */
			
			//管道流
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while((len=is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			System.out.println(baos.toString());			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//關閉資源
			if(baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

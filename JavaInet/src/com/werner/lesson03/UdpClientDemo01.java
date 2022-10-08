package com.werner.lesson03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//不需要連接服務器
//沒有真正的客戶端
public class UdpClientDemo01 {
	public static void main(String[] args) throws Exception {
		//1.建立一個Socket
		DatagramSocket socket = new DatagramSocket();  //用來發東西的	
		//2.建個包
		String msg = "你好，服務器!";
		 //發送給誰
		InetAddress localhost = InetAddress.getByName("localhost");
		int port = 9090;
		 //數據，數據長度(起始位置、結束位置)，發送對象(IP、port)
		DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
		//3.發送包		
		socket.send(packet);
		//4.關閉流
		socket.close();
	}
}

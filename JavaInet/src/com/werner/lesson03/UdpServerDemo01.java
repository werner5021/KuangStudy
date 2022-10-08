package com.werner.lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//沒有真正的服務器
//這裡服務端要先存在，才能接收到客戶端的包裹 -> 還是要等待客戶端的連接
public class UdpServerDemo01 {
	public static void main(String[] args) throws Exception {
		//開放port
		DatagramSocket socket = new DatagramSocket(9090);
		//接收數據(包)
		byte[] buffer = new byte[1024];
		DatagramPacket packet= new DatagramPacket(buffer, 0, buffer.length);  //接收不用管從哪裡來的
		
		socket.receive(packet);  //阻塞接收
		
		System.out.println(packet.getAddress().getHostAddress());
		System.out.println(new String(packet.getData()));
		
		//關閉連接
		socket.close();
	}
}

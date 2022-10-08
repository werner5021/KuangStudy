package com.werner.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSenderDemo01{
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(8888);
		
		//準備數據: 從控制台讀取System.in
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String data = reader.readLine();  //這裡的數據不可讀，必須轉成字節
			byte[] datas = data.getBytes();
			DatagramPacket packet = new DatagramPacket(datas,0,datas.length, new InetSocketAddress("localhost",6666));
			
			socket.send(packet);
			if(data.equals("bye")) {
				break;
			}
		}		
		socket.close();
	}
}

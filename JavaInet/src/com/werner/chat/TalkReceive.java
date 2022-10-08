package com.werner.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
	DatagramSocket socket = null;	
	private int port;
	private String msgFrom;
	
	public TalkReceive(int port, String msgFrom) {
		this.port = port;
		this.msgFrom = msgFrom;		
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				//準備接收的包裹
				byte[] container = new byte[1024];
				DatagramPacket packet = new DatagramPacket(container,0,container.length);
				socket.receive(packet);  //阻塞式接收包裹

				//斷開連接 bye
				byte[] data = packet.getData();
				String receiveData = new String(data, 0, data.length);
				
				System.out.println(msgFrom + " : "+receiveData);
				
				if(receiveData.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
		socket.close();
	
		
	}
}

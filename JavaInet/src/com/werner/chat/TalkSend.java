package com.werner.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
	
	DatagramSocket socket = null;   //建立連接，應該一進來就建立
	BufferedReader reader = null;
	
	private int fromPort;
	private String toIP;
	private int toPort;

	//初始化的數據應該放在構造器裡
	public TalkSend(int fromPort, String toIP, int toPort) {
		super();
		this.fromPort = fromPort;
		this.toIP = toIP;
		this.toPort = toPort;
		
		try {
			socket = new DatagramSocket(fromPort);
			//準備數據: 從控制台讀取System.in
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while(true) {
			try {
				String data = reader.readLine();  //這裡的數據不可讀，必須轉成字節
				byte[] datas = data.getBytes();
				DatagramPacket packet = new DatagramPacket(datas,0,datas.length, new InetSocketAddress(this.toIP, this.toPort));

				socket.send(packet);
				if(data.equals("bye")) {
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}		
		socket.close();
	}	
}

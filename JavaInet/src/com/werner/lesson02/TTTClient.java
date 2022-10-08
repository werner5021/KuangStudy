package com.werner.lesson02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TTTClient implements Runnable{

	DatagramSocket socket= null;
	BufferedReader reader = null;
	
	private int fromPort;
	private String toIP;
	private int toPort;

	
	public TTTClient(int fromPort) {
		try {
			socket = new DatagramSocket(fromPort);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		
		
	}
	
	
	
	
	
}

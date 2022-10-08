package com.werner.lesson01;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class TestInetSocketAddress {
	public static void main(String[] args) {
		InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
		System.out.println(inetSocketAddress);
		
		InetSocketAddress inetSocketAddress1 = new InetSocketAddress("localhost",8080);
		System.out.println(inetSocketAddress1);
		
		System.out.println(inetSocketAddress.getAddress());
		System.out.println(inetSocketAddress.getHostName());  //地址、主機名字
		System.out.println(inetSocketAddress.getPort());  //port號
		
	}
}

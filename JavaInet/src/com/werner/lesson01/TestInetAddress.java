package com.werner.lesson01;

import java.net.InetAddress;
import java.net.UnknownHostException;

//測試IP
public class TestInetAddress {
	public static void main(String[] args) {
		// new InetAddress();  InetAddress沒有建構子，不能new		
		try {
			//查詢本機地址
			InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
			System.out.println(inetAddress1);
			InetAddress inetAddress2 = InetAddress.getByName("localhost");
			System.out.println(inetAddress2);
			InetAddress inetAddress3 = InetAddress.getLocalHost();
			System.out.println(inetAddress3);

			//查詢網站IP地址
			InetAddress inetAddress4 = InetAddress.getByName("www.google.com");
			System.out.println(inetAddress4);
			
			//常用方法
			System.out.println(inetAddress4.getAddress());
			System.out.println(inetAddress4.getCanonicalHostName());  //查詢規範的名字
			System.out.println(inetAddress4.getHostAddress());  //IP
			System.out.println(inetAddress4.getHostName());  //域名，或自己電腦的名字						
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

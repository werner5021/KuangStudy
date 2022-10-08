package com.werner.chat;

public class TalkTeacher {
	public static void main(String[] args) {
		//開啟兩個線程
		new Thread(new TalkSend(555, "localhost", 8888)).start();  //學生的port是8888
		new Thread(new TalkReceive(9999, "學生")).start();
	}
}

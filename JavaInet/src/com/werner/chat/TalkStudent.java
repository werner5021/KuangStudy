package com.werner.chat;

public class TalkStudent {
	public static void main(String[] args) {
		//開啟兩個線程
		new Thread(new TalkSend(777, "localhost", 9999)).start();  //老師的port是9999
		new Thread(new TalkReceive(8888, "老師")).start();
	}
}

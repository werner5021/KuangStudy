package com.werner.chat;

public class TalkTeacher {
	public static void main(String[] args) {
		//�}�Ҩ�ӽu�{
		new Thread(new TalkSend(555, "localhost", 8888)).start();  //�ǥͪ�port�O8888
		new Thread(new TalkReceive(9999, "�ǥ�")).start();
	}
}

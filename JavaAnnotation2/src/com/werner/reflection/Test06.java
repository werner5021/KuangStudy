package com.werner.reflection;

//�������ƻ�ɭԷ|��l��
public class Test06 {
	
	static {
		System.out.println("main���Q�[��");
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		//�|���������ޥ� (������Ӹ귽)
		//1.�D�ʤޥ�
		Son son = new Son();  //main�B���B�l 
		
		//2.�Ϯg�]�|���ͥD�ʤޥ�
//		Class.forName("com.werner.reflection.Son");   //main�B���B�l
		
		
		//���|���������ޥΪ���k
		//1.�X���R�A��A�q�L�l���ޥΤ������R�A�ܶq�A�l�����|�Q�[��
//		System.out.println(Son.b);  //main�B��
		
		//2.�q�L�}�C�w�q���ޥΡA���|�[����
//		Son[] array = new Son[5];  //main
		
		//3.�եα`�q�����`�q
//		System.out.println(Son.M);  //main
		
	}
}

class Father{
	
	static int b = 2;
	
	static {
		System.out.println("�����Q�[��");
	}	
}

class Son extends Father{
	
	static {
		System.out.println("�l���Q�[��");
		m = 300;
	}
	
	static int m = 100;
	static final int M = 1;
	
}
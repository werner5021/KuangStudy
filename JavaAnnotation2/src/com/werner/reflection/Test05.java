package com.werner.reflection;

public class Test05 {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(A.m);
		
		/*
		   1.�[����O����A�|���ͤ@�ӹ���Class����H
		   2.�챵�A�챵������ m=0
		   3.��l�ơA<clinit>()��k�|�X�ְ���N�X
		  		<clinit>(){
		 				System.out.println("A���R�A�N�X��l��");
						m = 300;
						m = 100;
		  		}		  		
		  		m = 100
		 */
	}
}

class A{
	static {
		System.out.println("A���R�A�N�X��l��");
		m = 300;
	}
	
	/*
	 * m = 300
	 * m = 100
	 */
	
	
	static int m = 100;
	
	public A() {
		 System.out.println("A�����L�Ѻc�y��l��");
	}
	
	
}
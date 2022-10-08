package com.oop.demo05;

//重寫都是方法的重寫，和屬性無關
public class A extends B{

	public static void test() {
		System.out.println("A=>text()");
	}

	
	@Override    //重寫，用Source建的
	public void test1() {		
		System.out.println("A=>text()");
	}
	
	
	
}

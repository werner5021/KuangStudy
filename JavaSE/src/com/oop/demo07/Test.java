package com.oop.demo07;

//靜態導入包
import static java.lang.Math.random;
import static java.lang.Math.PI;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(Math.random());  //一般使用工具包
		
		System.out.println(random());  //將工具包靜態導入之後
		System.out.println(PI);  
		
		
	}
}

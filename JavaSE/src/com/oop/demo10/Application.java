package com.oop.demo10;

public class Application {
	
	public static void main(String[] args) {
		
		//new，外部類直接new
		Outer outer = new Outer();
		
		//通過外部類別來實例化內部類別
		Outer.Inner inner = outer.new Inner();
		inner.in();
		inner.getID();
		
	}
	
}

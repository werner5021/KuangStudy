package com.oop.demo05;

//在Java中，所有的類，都默認直接或間接繼承Object
//Person 人: 父類
public class Person /*extends Object*/{

	//public
	//protected
	//default
	//private	一般屬性都設私有的
	private int money = 10_0000_0000;
	
	public void say() {
		System.out.println("說了一句話");
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
/*===================================*/		
	
	protected String name = "IU";
	
	//如果調成私有的(private)，無法被繼承
	public void print() {
		System.out.println("Person");
	}

	
	public Person() {
		System.out.println("Person無參執行了");
	}
	
	
	
	
	
	
	
}

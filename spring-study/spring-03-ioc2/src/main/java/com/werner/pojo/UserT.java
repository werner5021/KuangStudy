package com.werner.pojo;

public class UserT {
	private String name;
	//無參構造
	public UserT() {
		System.out.println("UserT 被創建了");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void show() {
		System.out.println("name="+name);
	}
}

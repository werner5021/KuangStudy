package com.oop.demo09;

//interface 定義的關鍵字，介面都需要實現類
public interface UserService {
	
	//常量 public static final (一般不在介面中定義)
	int age = 99;
	
	//介面中的所有定義都是抽象的 public abstract
	public abstract void run();
	//public void run1() {};  不能寫實際的方法
	void run2();  //介面裡的方法不寫abstract也默認為抽象方法
	
	void add(String name);
	void delete(String name);
	void update(String name);
	void query(String name);
	
	
}

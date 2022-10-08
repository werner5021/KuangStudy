package com.oop.demo05;

//學生 is 人 : 派生類、子類
//子類繼承父類，就會擁有父類的全部方法
public class Student extends Person {

	//Ctrl + T 查看繼承樹
	
	private String name = "Jisoo";
	
	public void test(String name) {
		System.out.println(name);        //參數引入的
		System.out.println(this.name);   //當前的
		System.out.println(super.name);  //父類別的
	}
/*===================================*/	
	public void print() {
		System.out.println("Student");
	}
	
	public void test1() {
		print();
		this.print();
		super.print();
		}
	public void test() {
		
	}
/*===============================*/
	public Student() {
		//隱藏代碼，呼叫父類的無參構造		
		super();  //呼叫父類的建構子，必須要放在子類的第一行
		System.out.println("Student無參執行了");
	}
	
	
	
	
	
}

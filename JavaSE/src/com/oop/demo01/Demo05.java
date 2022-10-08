package com.oop.demo01;

//引用傳遞: 物件，本質還是值傳遞
public class Demo05 {

	public static void main(String[] args) {
		Person person = new Person();
		
		System.out.println(person.name);  //null
		
		Demo05.change(person);
		
		System.out.println(person.name);  //Werner

	}
	public static void change(Person person) {
		//person是一個物件: 指向 ---->Person person = new Person();這是一個具體的人，可以改變屬性
		person.name = "Werner";
	}
	

}

//定義一個Person類，有一個屬性: name
class Person{
	String name; //默認值為null
}
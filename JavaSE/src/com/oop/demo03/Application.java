package com.oop.demo03;

public class Application {

	public static void main(String[] args) {

		Pet dog = new Pet();
		dog.name = "小籠包";
		dog.age = 5;
		dog.shout();

		System.out.println(dog.name);
		System.out.println(dog.age);

		Pet cat = new Pet();

	}

}

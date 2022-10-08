package com.oop.demo02;

//java文件編譯後會生成class文件，看class文件
public class Person {

	// 一個類即使甚麼都不寫，也會存在一個構造方法

	String name;

	// 構造方法的作用:
	// 1.使用new關鍵字，本質是呼叫建構子
	// 2.用來初始化值
	public Person() {
		this.name = "werner";
	}

	// 有參構造，一旦定義了有參構造，無參構造必須顯示定義
	public Person(String name) {
		this.name = name;
	}

	// 快速生成建構子-> 右鍵 -> Source

}

/*
 * public static void main(String[] args) {
 * 
 * //new 實例化了一個對象 Person person = new Person("IU");
 * 
 * System.out.println(person.name); //null }
 * 
 * 建構子: 1.和類名相同 2.沒有回傳值 作用: 1.new 本質在呼叫建構子 2.初始化物件的值 注意點:
 * 1.定義有參構造之後，如果想使用無參構造，顯示定義一個無參構造
 * 
 * this. 代表自己這個類
 * 
 */

package com.werner.reflection;

//測試Class類的創建方式有哪些
public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException {
		//正常方式實體化 new
		Person person = new Student();
		System.out.println("這個人是"+person.name);
		
		//方式一: 通過對象獲得
		Class c1 = person.getClass();
		System.out.println(c1.hashCode());
		
		//方式二: forName獲得 (要有包名)
		Class c2 = Class.forName("com.werner.reflection.Student");
		System.out.println(c2.hashCode());
		
		//方式三: 通過類名.class獲得
		Class c3 = Student.class;
		System.out.println(c3.hashCode());
		
		//方式四: 基本內置類型的包裝類，都有一個Type屬性
		Class c4 = Integer.TYPE;
		System.out.println(c4);
		
		//獲得父類類型
		Class c5 = c1.getSuperclass();
		System.out.println(c5);			
	}
}

class Person{
	public String name;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}

class Student extends Person{
	public Student() {
		this.name = "學生";
	}
}

class Teacher extends Person{
	public Teacher() {
		this.name = "老師";
	}
}
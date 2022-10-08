package com.werner.reflection;

//什麼叫反射
public class Test02 extends Object{
	public static void main(String[] args) throws ClassNotFoundException {
		//通過反射獲取的Class對象
		Class c1 = Class.forName("com.werner.reflection.User"); //字串是包名+類名
		System.out.println(c1);
		
		Class c2 = Class.forName("com.werner.reflection.User");
		Class c3 = Class.forName("com.werner.reflection.User");
		Class c4 = Class.forName("com.werner.reflection.User");
		
		//一個類在記憶體中，只有一個Class對象
		//一個類被加載後，類的整個結構都會被封裝在class對象中
		System.out.println(c2.hashCode());  //印出hashCode以判斷是不是為同一個類
		System.out.println(c3.hashCode());
		System.out.println(c4.hashCode());
	}
}

//實體類: 取pojo、entity代表跟資料庫映射
class User{
	//1. 成員變量
	private String name;
	private int id;
	private int age;
	//2.無參構造
	public User() {
	}
	//3.有參構造
	public User(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}
	//4.get、set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	private void test() {
		
	}
	
	//5.toString()，方便寫程序的時候調適
	@Override
	public String toString() {
		return "User ["
				+ "name=" + name + ""
				+ ", id=" + id + ""
				+ ", age=" + age + 
				  "]";
	}
	
}
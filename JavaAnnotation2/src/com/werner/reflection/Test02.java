package com.werner.reflection;

//����s�Ϯg
public class Test02 extends Object{
	public static void main(String[] args) throws ClassNotFoundException {
		//�q�L�Ϯg�����Class��H
		Class c1 = Class.forName("com.werner.reflection.User"); //�r��O�]�W+���W
		System.out.println(c1);
		
		Class c2 = Class.forName("com.werner.reflection.User");
		Class c3 = Class.forName("com.werner.reflection.User");
		Class c4 = Class.forName("com.werner.reflection.User");
		
		//�@�����b�O���餤�A�u���@��Class��H
		//�@�����Q�[����A������ӵ��c���|�Q�ʸ˦bclass��H��
		System.out.println(c2.hashCode());  //�L�XhashCode�H�P�_�O���O���P�@����
		System.out.println(c3.hashCode());
		System.out.println(c4.hashCode());
	}
}

//������: ��pojo�Bentity�N����Ʈw�M�g
class User{
	//1. �����ܶq
	private String name;
	private int id;
	private int age;
	//2.�L�Ѻc�y
	public User() {
	}
	//3.���Ѻc�y
	public User(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}
	//4.get�Bset��k
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
	
	//5.toString()�A��K�g�{�Ǫ��ɭԽվA
	@Override
	public String toString() {
		return "User ["
				+ "name=" + name + ""
				+ ", id=" + id + ""
				+ ", age=" + age + 
				  "]";
	}
	
}
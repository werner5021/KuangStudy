package com.werner.reflection;

//����Class�����Ыؤ覡������
public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException {
		//���`�覡����� new
		Person person = new Student();
		System.out.println("�o�ӤH�O"+person.name);
		
		//�覡�@: �q�L��H��o
		Class c1 = person.getClass();
		System.out.println(c1.hashCode());
		
		//�覡�G: forName��o (�n���]�W)
		Class c2 = Class.forName("com.werner.reflection.Student");
		System.out.println(c2.hashCode());
		
		//�覡�T: �q�L���W.class��o
		Class c3 = Student.class;
		System.out.println(c3.hashCode());
		
		//�覡�|: �򥻤��m�������]�����A�����@��Type�ݩ�
		Class c4 = Integer.TYPE;
		System.out.println(c4);
		
		//��o��������
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
		this.name = "�ǥ�";
	}
}

class Teacher extends Person{
	public Teacher() {
		this.name = "�Ѯv";
	}
}
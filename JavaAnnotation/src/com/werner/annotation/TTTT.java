package com.werner.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;




public class TTTT {

	
	
	public static void main(String[] args) throws Exception {
		Class c1 = Class.forName("com.werner.annotation.Student3");
		
		Annotation[] annotations = c1.getAnnotations();
		for(Annotation annotation:annotations) {
			System.out.println(annotation);
		}
		
		TableJisoo tableJisoo = (TableJisoo) c1.getAnnotation(TableJisoo.class);
		String value = tableJisoo.value();
		System.out.println(value);

		Field f = c1.getDeclaredField("age");
		FieldJisoo annotation = f.getAnnotation(FieldJisoo.class);
		System.out.println(annotation.columnName());
		System.out.println(annotation.type());
		System.out.println(annotation.length());
	}	
}
@TableJisoo("db_student")
class Student3{
	@FieldJisoo(columnName="db_id", type = "int", length = 10)
	private int id;
	@FieldJisoo(columnName = "db_age", type="int", length = 10)
	private int age;
	@FieldJisoo(columnName = "db_name", type = "varchar", length = 3)
	private String name;

	public Student3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student3(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student3 [id=" + id + ", age=" + age + ", name=" + name + "]";
	}	
}
//���W������
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface TableJisoo{
	String value();
}

//�ݩʪ�����
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldJisoo{
	String columnName();
	String type();
	int length();
}










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
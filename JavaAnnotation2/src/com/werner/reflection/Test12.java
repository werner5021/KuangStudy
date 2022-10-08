package com.werner.reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//�m�ߤϮg�ާ@����
public class Test12 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class c1 = Class.forName("com.werner.reflection.Student2");

		// �q�L�Ϯg��o����
		Annotation[] annotations = c1.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}

		// ��o���Ѫ�value��
		TableWerner tableWerner = (TableWerner) c1.getAnnotation(TableWerner.class);
		String value = tableWerner.value();
		System.out.println(value);

		// ��o�����w������
		Field f = c1.getDeclaredField("name");  // ����oField��H 
		FieldWerner annotation = f.getAnnotation(FieldWerner.class);  // �A��Field��H�̪���k�h��o����
		System.out.println(annotation.columnName());
		System.out.println(annotation.type());
		System.out.println(annotation.length());

		// �H��ج[���O�A�b���̭��w�q�j�q���ѡA�q�L�Ϯg�ج[Ū������
		// ���]��Ʈw���i��A�q�L���ѩw�q�o�i��P�����������A�q�L���ѥͦ��ƾڮw���y���A�A�h�ާ@�W�R��d
	}
}

@TableWerner("db_student") // �ƾڮw�W�r��db_student
class Student2 {

	@FieldWerner(columnName = "db_id", type = "int", length = 10)
	private int id;
	@FieldWerner(columnName = "db_age", type = "int", length = 10)
	private int age;
	@FieldWerner(columnName = "db_name", type = "varchar", length = 3)
	private String name;

	public Student2() {
	}

	public Student2(int id, int age, String name) {
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
		return "Student2 [id=" + id + ", age=" + age + ", name=" + name + "]";
	}
}

//���W������
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableWerner {
	String value();
}

//�ݩʪ�����
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldWerner {
	String columnName();
	String type();
	int length();
}
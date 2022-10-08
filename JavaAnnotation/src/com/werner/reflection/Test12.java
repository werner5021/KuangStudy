package com.werner.reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//練習反射操作註解
public class Test12 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		Class c1 = Class.forName("com.werner.reflection.Student2");

		// 通過反射獲得註解
		Annotation[] annotations = c1.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}

		// 獲得註解的value值
		TableWerner tableWerner = (TableWerner) c1.getAnnotation(TableWerner.class);
		String value = tableWerner.value();
		System.out.println(value);

		// 獲得類指定的註解
		Field f = c1.getDeclaredField("name");  // 先獲得Field對象 
		FieldWerner annotation = f.getAnnotation(FieldWerner.class);  // 再用Field對象裡的方法去獲得註解
		System.out.println(annotation.columnName());
		System.out.println(annotation.type());
		System.out.println(annotation.length());

		// 以後框架都是，在類裡面定義大量註解，通過反射框架讀取註解
		// 假設資料庫有張表，通過註解定義這張表與對應的類型，通過註解生成數據庫的語言，再去操作增刪改查
	}
}

@TableWerner("db_student") // 數據庫名字為db_student
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

//類名的註解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableWerner {
	String value();
}

//屬性的註解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldWerner {
	String columnName();
	String type();
	int length();
}
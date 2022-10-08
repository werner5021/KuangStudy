package com.werner.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//獲得類的訊息
public class Test08 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		Class c1 = Class.forName("com.werner.reflection.User");

		User user = new User();
		Class c2 = user.getClass();  //通過對象找到包名、類名		
		
		//獲得類的名字
		System.out.println(c2.getName());  //獲得包名+類名
		System.out.println(c2.getSimpleName());  //獲得類名

		//獲的類的屬性
		System.out.println("======================");
		Field[] fields = c1.getFields();  //只能找到public屬性
//		for(Field field : fields) {
//			System.out.println(field);
//		}
		
		fields = c1.getDeclaredFields();  //找到全部的屬性
		for(Field field : fields) {
			System.out.println(field);
		}
		
		//獲得指定屬性的值
//		Field name = c1.getField("name");  
		Field name = c1.getDeclaredField("name");  //因為name是private，所以用getField會報錯
		System.out.println(name);
		
		System.out.println("======================");
		
		//獲得類的方法
		Method[] methods1 = c1.getMethods();  //獲得本類及其父類的全部方法
		for(Method method : methods1) {
			System.out.println("正常的: "+method);
		}
		Method[] methods2 = c1.getDeclaredMethods();  //獲得本類的所有方法
		for(Method method : methods2) {
			System.out.println("getDeclaredMethods: "+method);
		}
		
		//獲得指定的方法
		//因為有重載，所以需要參數識別是哪一個方法
		Method getName = c1.getMethod("getName", null);
		System.out.println(getName);		
		Method setName = c1.getMethod("setName", String.class);
		System.out.println(setName);
		
		System.out.println("======================");
		
		//獲得構造器
		Constructor[] constructors1 = c1.getConstructors();
		for(Constructor constructor : constructors1) {
			System.out.println("1:"+ constructor);
		}
		Constructor[] constructors2 = c1.getDeclaredConstructors();
		for(Constructor constructor : constructors2) {
			System.out.println("2:"+ constructor);
		}
		
		//獲得指定的構造器
		Constructor constructors3 = c1.getDeclaredConstructor(String.class, int.class, int.class);
		System.out.println("指定:" + constructors3);
				
	}

}

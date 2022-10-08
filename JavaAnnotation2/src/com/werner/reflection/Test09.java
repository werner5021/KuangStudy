package com.werner.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//動態的創建對象，通過反射
public class Test09 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		//獲得Class對象
		Class c1 = Class.forName("com.werner.reflection.User");
		
		//構造一個對象
		User user = (User) c1.getConstructor().newInstance();  //本質是調用無參構造器，沒有無參構造器就會報錯
			//newInstance 返回 Object，強轉成User
			//通過反射構造一個user對象
		System.out.println(user);  //User [name=null, id=0, age=0] → 代表調用無參構造器
		
		//通過構造器創建對象		 
		Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
			//必須有這個構造器，先獲得構造器
		User user2 = (User) constructor.newInstance("werner",001,30);
			//通過構造器創建對象
			//newInstance 返回 Object，強轉成User
		System.out.println(user2);
				
		
		//通過反射調用普通方法
		User user3 = (User) c1.getConstructor().newInstance();   
		//通過反射獲取一個方法
		Method setName = c1.getDeclaredMethod("setName", String.class);
		//invoke 激活 
		//(對象, "方法的值")
		setName.invoke(user3, "知恩");  
		System.out.println(user3.getName());
		
		//通過反射操作屬性
		System.out.println("===========================");
		User user4 = (User) c1.getDeclaredConstructor().newInstance();
		Field name = c1.getDeclaredField("name");
		
		//不能直接操作私有屬性，我們需要關閉程序的安全檢測，屬性或方法的setAccessible(true)
		//安全檢測關掉之後，就可以隨意執行
		name.setAccessible(true);  //設定訪問權限能不能被訪問，預設false不能訪問private，改true就可以訪問private
		name.set(user4, "智秀");
		System.out.println(user4.getName());
	}
}

package com.werner.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//���R�ʯ���D
public class Test10 {
	
	//���q��k�ե�
	public static void test01() {
		User user = new User();
		
		long startTime = System.currentTimeMillis();
		
		for(int i =0; i<1000000000; i++) {
			user.getName();
		}		
		long endTime = System.currentTimeMillis();
		System.out.println("���q�覡����10����:"+(endTime-startTime)+"ms");
	}
	
	
	//�Ϯg�覡�ե�
	public static void test02() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		User user = new User();
		Class c1 = user.getClass();
		
		Method getName = c1.getDeclaredMethod("getName", null);
	
		long startTime = System.currentTimeMillis();
		
		for(int i =0; i<1000000000; i++) {
			getName.invoke(user, null);
		}		
		long endTime = System.currentTimeMillis();
		System.out.println("�Ϯg�覡����10����:"+(endTime-startTime)+"ms");	
	}	
	
	//�Ϯg�覡�եΡA�����˴�
	public static void test03() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		User user = new User();
		Class c1 = user.getClass();
		
		Method getName = c1.getDeclaredMethod("getName", null);
		getName.setAccessible(true);
		
		long startTime = System.currentTimeMillis();
		
		for(int i =0; i<1000000000; i++) {
			getName.invoke(user, null);
		}		
		long endTime = System.currentTimeMillis();
		System.out.println("�����˴�����10����:"+(endTime-startTime)+"ms");	
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		test01();
		test02();
		test03();
	}
	
}

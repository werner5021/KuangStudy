package com.werner.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//分析性能問題
public class Test10 {
	
	//普通方法調用
	public static void test01() {
		User user = new User();
		
		long startTime = System.currentTimeMillis();
		
		for(int i =0; i<1000000000; i++) {
			user.getName();
		}		
		long endTime = System.currentTimeMillis();
		System.out.println("普通方式執行10億次:"+(endTime-startTime)+"ms");
	}
	
	
	//反射方式調用
	public static void test02() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		User user = new User();
		Class c1 = user.getClass();
		
		Method getName = c1.getDeclaredMethod("getName", null);
	
		long startTime = System.currentTimeMillis();
		
		for(int i =0; i<1000000000; i++) {
			getName.invoke(user, null);
		}		
		long endTime = System.currentTimeMillis();
		System.out.println("反射方式執行10億次:"+(endTime-startTime)+"ms");	
	}	
	
	//反射方式調用，關閉檢測
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
		System.out.println("關閉檢測執行10億次:"+(endTime-startTime)+"ms");	
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		test01();
		test02();
		test03();
	}
	
}

package com.werner.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//��o�����T��
public class Test08 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		Class c1 = Class.forName("com.werner.reflection.User");

		User user = new User();
		Class c2 = user.getClass();  //�q�L��H���]�W�B���W		
		
		//��o�����W�r
		System.out.println(c2.getName());  //��o�]�W+���W
		System.out.println(c2.getSimpleName());  //��o���W

		//�������ݩ�
		System.out.println("======================");
		Field[] fields = c1.getFields();  //�u����public�ݩ�
//		for(Field field : fields) {
//			System.out.println(field);
//		}
		
		fields = c1.getDeclaredFields();  //���������ݩ�
		for(Field field : fields) {
			System.out.println(field);
		}
		
		//��o���w�ݩʪ���
//		Field name = c1.getField("name");  
		Field name = c1.getDeclaredField("name");  //�]��name�Oprivate�A�ҥH��getField�|����
		System.out.println(name);
		
		System.out.println("======================");
		
		//��o������k
		Method[] methods1 = c1.getMethods();  //��o�����Ψ������������k
		for(Method method : methods1) {
			System.out.println("���`��: "+method);
		}
		Method[] methods2 = c1.getDeclaredMethods();  //��o�������Ҧ���k
		for(Method method : methods2) {
			System.out.println("getDeclaredMethods: "+method);
		}
		
		//��o���w����k
		//�]���������A�ҥH�ݭn�Ѽ��ѧO�O���@�Ӥ�k
		Method getName = c1.getMethod("getName", null);
		System.out.println(getName);		
		Method setName = c1.getMethod("setName", String.class);
		System.out.println(setName);
		
		System.out.println("======================");
		
		//��o�c�y��
		Constructor[] constructors1 = c1.getConstructors();
		for(Constructor constructor : constructors1) {
			System.out.println("1:"+ constructor);
		}
		Constructor[] constructors2 = c1.getDeclaredConstructors();
		for(Constructor constructor : constructors2) {
			System.out.println("2:"+ constructor);
		}
		
		//��o���w���c�y��
		Constructor constructors3 = c1.getDeclaredConstructor(String.class, int.class, int.class);
		System.out.println("���w:" + constructors3);
				
	}

}

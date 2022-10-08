package com.werner.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//�ʺA���Ыع�H�A�q�L�Ϯg
public class Test09 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		//��oClass��H
		Class c1 = Class.forName("com.werner.reflection.User");
		
		//�c�y�@�ӹ�H
		User user = (User) c1.getConstructor().newInstance();  //����O�եεL�Ѻc�y���A�S���L�Ѻc�y���N�|����
			//newInstance ��^ Object�A�j�নUser
			//�q�L�Ϯg�c�y�@��user��H
		System.out.println(user);  //User [name=null, id=0, age=0] �� �N��եεL�Ѻc�y��
		
		//�q�L�c�y���Ыع�H		 
		Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
			//�������o�Ӻc�y���A����o�c�y��
		User user2 = (User) constructor.newInstance("werner",001,30);
			//�q�L�c�y���Ыع�H
			//newInstance ��^ Object�A�j�নUser
		System.out.println(user2);
				
		
		//�q�L�Ϯg�եδ��q��k
		User user3 = (User) c1.getConstructor().newInstance();   
		//�q�L�Ϯg����@�Ӥ�k
		Method setName = c1.getDeclaredMethod("setName", String.class);
		//invoke �E�� 
		//(��H, "��k����")
		setName.invoke(user3, "����");  
		System.out.println(user3.getName());
		
		//�q�L�Ϯg�ާ@�ݩ�
		System.out.println("===========================");
		User user4 = (User) c1.getDeclaredConstructor().newInstance();
		Field name = c1.getDeclaredField("name");
		
		//���ઽ���ާ@�p���ݩʡA�ڭ̻ݭn�����{�Ǫ��w���˴��A�ݩʩΤ�k��setAccessible(true)
		//�w���˴���������A�N�i�H�H�N����
		name.setAccessible(true);  //�]�w�X���v���ण��Q�X�ݡA�w�]false����X��private�A��true�N�i�H�X��private
		name.set(user4, "���q");
		System.out.println(user4.getName());
	}
}

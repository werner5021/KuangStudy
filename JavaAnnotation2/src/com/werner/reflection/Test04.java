package com.werner.reflection;

import java.lang.annotation.ElementType;

//�Ҧ�������class
public class Test04 {
	
	public static void main(String[] args) {
		Class c1 = Object.class;  //��
		Class c2 = Comparable.class;  //����
		Class c3 = String[].class;  //�@���}�C
		Class c4 = int[][].class;  //�G���}�C
		Class c5 = Override.class;  //����
		Class c6 = ElementType.class;  //�T�|
		Class c7 = Integer.class;  //�򥻫��O
		Class c8 = void.class;  //void����
		Class c9 = Class.class;  //Class
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
		System.out.println(c8);
		System.out.println(c9);
		
		//�u�n���������P���פ@�ˡA�N�O�P�@��Class
		//��X���G�ۦP �� ��Ӫ��פ��@�˪��}�C�A�u�n�����@�ˡAClass���N�@�w�@��
		int[] a = new int[10];
		int[] b = new int[100];		
		System.out.println(a.getClass().hashCode());
		System.out.println(b.getClass().hashCode());
		
	}
	
}

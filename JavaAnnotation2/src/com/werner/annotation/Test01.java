package com.werner.annotation;

import java.util.ArrayList;
import java.util.List;

//�ƻ�O����

public class Test01 extends Object {

	//@Override ���g������
	//���Ѧ��ˬd��������@�� toString �令 tostring �N�|����
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	//Deprecated  �����ˤu�{�v�ϥΡA���i�H�ϥΡA�Φs�b��n���覡
	@Deprecated 
	public static void test() {
		System.out.println("Deprecated");
	}
	
	//SuppressWarnings ����ĵ�i
	@SuppressWarnings("all")  
	public void test02() {
		List list = new ArrayList();
	}
	
	
	public static void main(String[] args) {
		test();
	}
	
	
	
	
	
}

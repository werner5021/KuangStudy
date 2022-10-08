package com.werner.reflection;

public class Test07 {
	public static void main(String[] args) throws ClassNotFoundException {
		//����t�����[����
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader);
		
		//����t�����[���������� �� �ݮi���[����
		ClassLoader parent = systemClassLoader.getParent();
		System.out.println(parent);
		
		//��o�ݮi���[���������� �� �ڥ[����
		ClassLoader grandParent = parent.getParent();
		System.out.println(grandParent);  //�ڥ[�����OŪ���֤ߤ����AJavaŪ������
		
		
		//���շ�e���O���ӥ[�����[����
		ClassLoader classLoader = Class.forName("com.werner.reflection.Test07").getClassLoader();
		System.out.println(classLoader);  //�۩w�q�����ݩ�Τ����[����
	
		//����JDK���m�����O���ӥ[�����[���� 
		classLoader = Class.forName("java.lang.Object").getClassLoader();
		System.out.println(classLoader);  //Object���ݩ�rt.jar�]�U���t�ΡA�ݩ�ڥ[�����[�����A�ҥH�L�k�L�X
		
		//�p����o�t�����[�����i�H�[�������|?		
		System.out.println(System.getProperty("java.class.path"));
		
		//���˩e������
			//�h���˴��A�H�O�Ҧw����
		    //�p�G�۩w�qjava.lang.String�A�|���h��t�����[�����B�ݮi���[�����B�ڥ[�����A�o�{�ڥ[�����̦��o�ӥ]�A�۩w�q�N�L��
		
	}
}

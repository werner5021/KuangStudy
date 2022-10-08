package com.werner.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//���դ�����
@MyAnnotation
public class Test02 {
	
	@MyAnnotation
	public void test() {		
	}	
	
	public static void main(String[] args) {		
	}
}

//�w�q�@�ӵ��� (���H�N�ݤ@�ӵ��Ѫ���l�X�o�{���Opublic @interface xxx{})

//Target ��ܧڭ̪����ѥi�H�Φb����a��
@Target(value = {ElementType.METHOD, ElementType.TYPE})  
   //ElementType.METHOD �w�q�b��k�W
   //ElementType.TYPE   �w�q�b���W

//��ܵ��Ѧb����a���٦���
//RUNTIME>CLASS>SOURCE 
@Retention(value = RetentionPolicy.RUNTIME)

//Documented ��ܬO�_�N�ڭ̪����ѥͦ��bJavadoc��
@Documented

//Inherited �l���i�H�~�Ӥ���������
@Inherited
@interface MyAnnotation{

}

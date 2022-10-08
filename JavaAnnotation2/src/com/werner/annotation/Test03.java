package com.werner.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//�۩w�q����
public class Test03 {
	//���ѥi�H��ܽ�ȡA�p�G�S���q�{�ȡA�ڭ̴N���������ѽ��
	@MyAnnotation2(name = "Yoona", schools = "�M�ؤj��", age = 30)  //���Ѥ��ζ���
	public void test() {		
	}
	
	@MyAnnotation3("IU")  //���ѰѼƥu���@�ӡA�B�ѼƦW��value�ɡA�i�ٲ��ѼƦW�A�Ӫ����g��
	public void test2() {
	}
}


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
	//���Ѫ��Ѽ�:�Ѽ�����+�ѼƦW(); 
	String name() default "";  //�p�G���q�{�ȡA�i�H���g���Ѫ��Ѽ�
	int age() default 0;
	int id() default -1;  //�p�G�q�{�Ȭ�-1�N���s�b�A�pindexof�䤣���^-1
	
	String[] schools() default {"�����j��","�y���j��"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
	String value();  //�u���@�ӰѼƫ�ĳ��value
}
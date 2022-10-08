package com.werner.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定義註解
public class Test03 {
	//註解可以顯示賦值，如果沒有默認值，我們就必須給註解賦值
	@MyAnnotation2(name = "Yoona", schools = "清華大學", age = 30)  //註解不用順序
	public void test() {		
	}
	
	@MyAnnotation3("IU")  //註解參數只有一個，且參數名為value時，可省略參數名，而直接寫值
	public void test2() {
	}
}


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
	//註解的參數:參數類型+參數名(); 
	String name() default "";  //如果有默認值，可以不寫註解的參數
	int age() default 0;
	int id() default -1;  //如果默認值為-1代表不存在，如indexof找不到返回-1
	
	String[] schools() default {"首爾大學","慶應大學"};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
	String value();  //只有一個參數建議用value
}
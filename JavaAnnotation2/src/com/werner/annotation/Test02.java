package com.werner.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//測試元註解
@MyAnnotation
public class Test02 {
	
	@MyAnnotation
	public void test() {		
	}	
	
	public static void main(String[] args) {		
	}
}

//定義一個註解 (先隨意看一個註解的原始碼發現都是public @interface xxx{})

//Target 表示我們的註解可以用在什麼地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})  
   //ElementType.METHOD 定義在方法上
   //ElementType.TYPE   定義在類上

//表示註解在什麼地方還有效
//RUNTIME>CLASS>SOURCE 
@Retention(value = RetentionPolicy.RUNTIME)

//Documented 表示是否將我們的註解生成在Javadoc中
@Documented

//Inherited 子類可以繼承父類的註解
@Inherited
@interface MyAnnotation{

}

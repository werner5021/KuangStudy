package com.werner.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等價於 <bean id="user" class="com.werner.pojo.User"/>
//Component 組件
@Component
@Scope("singleton")
public class User {
	
	//相當於 <property name="name" value="雪炫"/>
	//@Value放在屬性、set方法都可以注入
	@Value("雪炫")
	public String name ;
	
	public void setName(String name) {
		this.name = name;
	}
	

}

package com.werner.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//import javax.annotation.Resource;

public class People {
	
	//如果顯示定義 Autowired 的屬性為 false，說明這個對象可以為null，否則不允許為空
//	@Autowired(required = false);
	
	@Autowired
	@Qualifier(value ="cat222")
	private Cat cat;
	@Autowired
	@Qualifier(value ="dog222")
	private Dog dog;
	
//	@Resource
//	private Cat cat;
//	@Resource
//	private Dog dog;
	
	private String name;
	
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "People [cat=" + cat + ", dog=" + dog + ", name=" + name + "]";
	}
	
	
}

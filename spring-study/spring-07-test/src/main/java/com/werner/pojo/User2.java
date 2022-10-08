package com.werner.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User2 {
	
	private String name;

	public String getName() {
		return name;
	}

	@Value("EXID")
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

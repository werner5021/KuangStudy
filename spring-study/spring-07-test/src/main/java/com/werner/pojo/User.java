package com.werner.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;

	public String getName() {
		return name;
	}

	@Value("LISA")
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

package com.werner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.werner.pojo.User;

@Configuration
@ComponentScan("com.werner.pojo")
@Import(MyConfig2.class)
public class MyConfig {
	
	@Bean
	public User getUser() {
		return new User();
	}
	
}
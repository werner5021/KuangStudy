package com.werner.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//這個註解的意思，就是說明這個類被Spring接管，註冊到了容器中
@Component
public class User {
	private String name;  //這裡不能加上@Autowired，會重複註冊，報錯

	public String getName() {
		return name;
	}

	@Value(value = "秀智")  //屬性注入值
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}	
	
}

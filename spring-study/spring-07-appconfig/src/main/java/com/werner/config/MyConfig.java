package com.werner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.werner.pojo.User;

// 也會被Spring託管，註冊到容器中，因為它本來就是一個@Component
// @Configuration代表這是一個配置類，就和我們之前看的beans.xml一樣
@Configuration  
@ComponentScan("com.werner.pojo")  //實測會自動尋找同一目錄下的所有class檔
@Import(MyConfig2.class)  //引入配置類的class對象，相當於導入
public class MyConfig {
	
	//註冊一個bean，就相當於我們之前寫的一個bean標籤
	//這個方法的名字，就相當於bean標籤中的id屬性
	//這個方法的返回值，就相當於bean標籤中的class屬性
	@Bean
	public User getUser() {
		return new User();  //就是返回要注入到bean的對象
	}
	
}

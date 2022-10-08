package com.werner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.werner.pojo.User;

@RestController
public class AjaxController {

	@RequestMapping("/t1")
	public String test() {
		return "hello";
	}

	@RequestMapping("/a1")
	public void a1(String name, HttpServletResponse resp) throws IOException { 

		System.out.println("username="+name);

		if(name.equals("jisoo")) {
			resp.getWriter().print("true");
		}else {
			resp.getWriter().print("false");
		}
	}

	@RequestMapping("/a2")
	public List<User> a2(){
		
		List<User> userList = new ArrayList<User>();
		
		userList.add(new User("張三",25,"男"));
		userList.add(new User("李四",26,"男"));
		userList.add(new User("王舞",27,"女"));
		
		return userList;
	}
	
	
	@RequestMapping("/a3")
	public String a3(String name, String pwd) {
		String msg = "";
		if(name != null) {
			if(name.equals("admin")) {
				msg="用戶正確";
			}else {
				msg="用戶錯誤";
			}
		}
		if(pwd != null) {
			if(pwd.equals("123456")) {
				msg="密碼正確";
			}else {
				msg="密碼錯誤";
			}
		}
		return msg;
		
	}
	
}

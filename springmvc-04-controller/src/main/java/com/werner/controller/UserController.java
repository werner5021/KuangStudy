package com.werner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.werner.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	//從前端接收的是參數
	//localhost:8080/springmvc-04-controller/user/t1?name=xxx
	@GetMapping("/t1")
	public String test1(@RequestParam("username") String name, Model model) {
		//@RequestParam加上後就能明顯知道是前端傳來的參數，建議一律都寫
		
		//1.接收前端參數
		System.out.println("接收到前端的參數為:" + name);
		
		//2.將返回的結果傳輸給前端
		model.addAttribute("msg", name);
		
		//3.視圖跳轉
		return "test";
	}
	
	//從前端接收的是對象: id, name, age
	/*
	 * 1. 接收用戶傳遞的參數，判斷參數的名字，假設名字直接在方法上，可以直接使用
	 * 2. 假設傳遞的是一個對象User，匹配User對象中的字段名:如果名字一致則可，否則匹配不到
	 */		
	@GetMapping("/t2")
	public String test2(User user) {  //這裡demo不返回數據給前端，所以不用Model
		System.out.println(user.toString());
		return "test";
	}
	
	//Model繼承ModelMap，ModelMap繼承LinkedHashMap
	
	@GetMapping("/t3")
	public String test3(User user, ModelMap map) {
		
		map.addAttribute(user.getName());
		System.out.println(user.getName());
		return "test";
	}	
	
	
	
	
}

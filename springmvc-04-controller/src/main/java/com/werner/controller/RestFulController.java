package com.werner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

	//原來的:    http://localhost:8080/springmvc-03-annotation/add?a=1&b=2
	//Restful:  http://localhost:8080/springmvc-03-annotation/add/a/b

/*	
	//映射訪問路徑
	@RequestMapping("/add")
	public String test1(int a, int b, Model model) {  //這裡定義的名字a、b就是從前端傳過來，跳轉時沒有a、b參數會報錯
		int res = a+b;
		//SpringMVC會自動實體化一個Model
		model.addAttribute("msg", "結果為:"+res);		
		//返回視圖位置
		return "test";
	}
 */	

/*
	@RequestMapping("/add/{a}/{b}")  //如果要使用GET以外的方法，點進@RequestMapping看方法
	@RequestMapping(value="/add/{a}/{b}", method = RequestMethod.GET)  //限定使用DELETE方式獲得請求
	public String test2(@PathVariable int a, @PathVariable int b, Model model) {  
		int res = a+b;  
		model.addAttribute("msg", "結果為2:"+res);		
		return "test";
	}
*/
	
	//訪問地址為 http://localhost:8080/springmvc-04-controller/add/1/2
	@PostMapping("/add/{a}/{b}")  
	public String test3(@PathVariable int a, @PathVariable int b, Model model) {  
		int res = a+b;  
		model.addAttribute("msg", "結果為3:"+res);		
		return "test";
	}
	
	//訪問地址為 http://localhost:8080/springmvc-04-controller/add/1/2
	@GetMapping("/add/{a}/{b}")  
	public String test4(@PathVariable int a, @PathVariable int b, Model model) {  
		int res = a+b;  
		model.addAttribute("msg", "結果為4:"+res);		
		return "test";
	}
}

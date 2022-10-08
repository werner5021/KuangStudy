package com.werner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //代表這個類會被Spring接管，這個註解的類中的所有方法，如果返回值是String，並且有具體的頁面可以跳轉，就拼接字串為路徑
public class ControllerTest2 {
	
	//映射訪問路徑
	@RequestMapping("/t1")
	public String test1(Model model) {		
		//Spring MVC會自動實體化一個Model對象用於視圖中傳值
		model.addAttribute("msg","test1");		
		//返回視圖位置
		return "test";  //代表視圖解析器
	}
	@RequestMapping("/t3")  
	public String test3(Model model) {		
		//Spring MVC會自動實體化一個Model對象用於視圖中傳值
		model.addAttribute("msg","test3");		
		//返回視圖位置
		return "test";  //代表視圖解析器
	}
	
	//兩個方法會返回共同的頁面
}

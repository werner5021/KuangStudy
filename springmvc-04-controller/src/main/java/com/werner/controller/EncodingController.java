package com.werner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {

	//過濾器解決亂碼
	@PostMapping("/e/t1")  //我們自訂的過濾器無法解決Post的亂碼，還是用Spring框架做的過濾器較好
//	@GetMapping("/e/t1")
	public String test1(String name, Model model) {
		
		System.out.println(name);  // 後台輸出看甚麼時候變亂碼的
		model.addAttribute("msg",name);
		return "test";
	}
}

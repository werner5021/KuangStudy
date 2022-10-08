package com.werner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {

	@RequestMapping("/click")
	public String hello(Model model) {
		model.addAttribute("msg", "哈哈哈");
		return "hello";
	}
	
}
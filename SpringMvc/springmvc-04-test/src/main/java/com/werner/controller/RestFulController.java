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
	
	@RequestMapping("/add")
	public String test1(int a, int b , Model model) {
		int res = a+b;
		model.addAttribute("msg", "結果為="+res);
		return "test";
	}
	
	@RequestMapping(value="/add/{a}/{b}", method=RequestMethod.DELETE)
	public String test2(@PathVariable int a, @PathVariable int b, Model model) {
		int res = a-b;
		model.addAttribute("msg", "結果為="+res);
		return "test";
	}
	
//	@GetMapping("/add/{a}/{b}")
//	public String testGet(Model model, @PathVariable int a, @PathVariable int b) {
//		int res=  a+b;
//		model.addAttribute("msg", "a+b="+res);
//		return "test";
//	}
//	
//	@PostMapping("/add/{a}/{b}")
//	public String testPost(Model model, @PathVariable int a, @PathVariable int b) {
//		int res = a-b;
//		model.addAttribute("msg", "a-b="+res);
//		return "test";
//		
//	}
	
	
	
	
}

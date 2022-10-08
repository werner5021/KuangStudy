package com.werner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c2")
public class ControllerTest2 {
	
	@RequestMapping("/t2")
	public String test2(Model model) {
		model.addAttribute("msg", "ControllerTest2 測試成功");
		return "test";
	}
	
}

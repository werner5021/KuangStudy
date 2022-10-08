package com.werner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.werner.pojo.User;

@Controller
@RequestMapping(value="/user", method=RequestMethod.GET)
public class UserController {

	@RequestMapping("/t1")
	public String test1(String name,Model model) {
		model.addAttribute("msg", name);				
		return "test";
	}
	
	@RequestMapping("/t2")
	public String test2(@RequestParam("username")String name,Model model) {
		model.addAttribute("msg",name);
		return "test";
	}
	
	@RequestMapping("/t3")
	public String test3(User user, Model model) {
		
		model.addAttribute("msg", user.toString());
		return "test";
	}
	
	@RequestMapping("/t4")
	public String test4(User user , ModelMap map) {
		map.addAttribute("msg", user.getName());
		return "test";
	}
}

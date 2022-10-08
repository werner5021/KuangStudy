package com.werner.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {

	@RequestMapping("/goLogin")
	public String goLogin() {
		return "login";
	}
	@RequestMapping("/goMain")
	public String goMain() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session , Model model) {
		session.setAttribute("userLoginInfo", username);
		model.addAttribute("username", username);
		return "main";
	}
	@RequestMapping("/logout")
	public String logout(String userLoginInfo, HttpSession session) {
		session.removeAttribute("userLoginInfo");
		return "main";
	}
	
	
}

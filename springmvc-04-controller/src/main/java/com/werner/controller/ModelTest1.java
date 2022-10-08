package com.werner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTest1 {

	//通過req、resp也能做到跳轉頁面，這裡就沒有用到視圖解析
	@RequestMapping("/m1/t1")
	public String test1(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		System.out.println(session.getId());		
		return "test";  //有視圖解析器的寫法
	}
	
	@RequestMapping("/m1/t2")
	public String test2(Model model) {
		
		model.addAttribute("msg", "ModelTest1");		
//		return "/WEB-INF/jsp/test.jsp";  //沒有視圖解析器，用轉發
//		return "forward:/WEB-INF/jsp/test.jsp";  //沒有視圖解析器，用轉發
		return "redirect:/index.jsp";  //沒有視圖解析器，用重定向
	}
}

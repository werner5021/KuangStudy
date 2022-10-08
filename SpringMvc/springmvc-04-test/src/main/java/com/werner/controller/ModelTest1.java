package com.werner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTest1 {

	@RequestMapping("/m1/t1")
	public void test1(HttpServletRequest req, HttpServletResponse resp) throws IOException {		
		HttpSession session = req.getSession();
		resp.getWriter().print(session.getId());		
	}
	@RequestMapping("/m1/t2")
	public void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}
	
	@RequestMapping("/m1/t3")
	public void test3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("msg", "LALALA");
		req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req, resp);
	}

	
	@RequestMapping("/m1/t4")
	public String test4(Model model) {
		
		model.addAttribute("msg", "ModelTest1-4");
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/m1/t5")
	public String test5(Model model) {
		
		model.addAttribute("msg", "ModelTest1-5");
		return "/WEB-INF/jsp/test.jsp";
	}
	
	@RequestMapping("/m1/t6")
	public String test6(Model model) {
		
		model.addAttribute("msg", "ModelTest1-6");
		return "forward:/WEB-INF/jsp/test.jsp";
	}
	
	
	
	
	
	
	
}

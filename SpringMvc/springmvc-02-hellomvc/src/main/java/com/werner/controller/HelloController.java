package com.werner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView 模型和视图
		ModelAndView mv = new ModelAndView();	 

		//調用業務層(但這裡沒有)，業務代碼
		
		//模型:處理數據
		//封装对象，放在ModelAndView中。Model
		mv.addObject("msg","HelloSpringMVC!");
		//視圖:跳轉到哪裡
		//封装要跳转的视图，放在ModelAndView中
		//視圖跳轉，設置視圖的名字
		mv.setViewName("hello"); //自動拼接成: /WEB-INF/jsp/hello.jsp
		return mv;
	}

}

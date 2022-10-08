package com.werner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//定义控制器
//注意点：不要导错包，实现Controller接口，重写方法；
//只要實現了Controller介面的類，說明這就是一個控制器
public class ControllerTest1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 //返回一个模型视图对象
		ModelAndView mv = new ModelAndView();		
		mv.addObject("msg", "ControllerTes1");		
		mv.setViewName("test");
		return mv;
	}
}

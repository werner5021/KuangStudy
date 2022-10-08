package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		this.getInitParameter();  初始化參數，知道有這個就好
//		this.getServletConfig();  Servlet配置，知道有這個就好
		ServletContext context = this.getServletContext();  //Servlet上下文
		
		//放數據到ServletContext中
		String username = "知恩";  //數據
		context.setAttribute("username", username);  //將一個數據保存在ServletContext中，名字為:username、值為:username
		
		
		System.out.println("Hello");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

package com.werner.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//後台接收中文亂碼問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//獲取所有參數
		String username = req.getParameter("username");  //getParameter()獲取單個參數
		String password = req.getParameter("password");
		String[] hobbys = req.getParameterValues("hobbys");  //getParameterValues()獲取多個值
		
		System.out.println("===============");		
		System.out.println(username);
		System.out.println(password);		
		System.out.println(Arrays.toString(hobbys));
		System.out.println("===============");
		
		//通過請求轉發		
		//這裡的"/"代表當前的 web 應用
		req.getRequestDispatcher("/success.jsp").forward(req, resp);
//		resp.sendRedirect("/request/success.jsp");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

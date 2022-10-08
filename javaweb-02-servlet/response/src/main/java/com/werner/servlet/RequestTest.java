package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入這個請求");
		
		//處理請求
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username+":"+password);
		
		//重新導向一定要注意路徑問題，否則404
		resp.sendRedirect("/response/success.jsp");		
	}	 
}

package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getParameter("method");
		
		if(method.equals("add")) {
			req.getSession().setAttribute("msg", "使用了"+method+"方法");
		}
		if(method.equals("delete")) {
			req.getSession().setAttribute("msg", "使用了"+method+"方法");
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
	
}

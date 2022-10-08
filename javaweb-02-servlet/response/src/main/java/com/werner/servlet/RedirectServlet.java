package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 重新導向實際做的事
		 resp.setHeader("Location", "/response/img");
		 resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);  //302
		 */		
		resp.sendRedirect("/response/img");   //重新導向
	}	
}

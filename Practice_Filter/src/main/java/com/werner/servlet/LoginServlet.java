package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.werner.util.Constants;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		
		if(username.equals("admin")) {
			req.getSession().setAttribute(Constants.USER_SESSION, req.getSession().getId());
			resp.sendRedirect(req.getContextPath()+"/sys/success.jsp");
		}else {
			resp.sendRedirect(req.getContextPath()+"/error.jsp");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

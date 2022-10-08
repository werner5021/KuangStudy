package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.werner.util.Constants;

public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object userSession = req.getSession().getAttribute(Constants.USER_SESSION);
//		req.getSession().removeAttribute(Constants.USER_SESSION);
		
		if(userSession != null) {
			req.getSession().removeAttribute(Constants.USER_SESSION);
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
		}else {
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
		}
		
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

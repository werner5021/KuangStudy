package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.werner.pojo.Person;

public class SessionDemo01 extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();
		
		session.setAttribute("name", new Person("yeonwoo", 26, 1, "首爾市"));
		
		String sessionID = session.getId();
		
		if(session.isNew()) {
			resp.getWriter().write("Create: " + sessionID);
		}else {
			resp.getWriter().write("Existed: " + sessionID);			
		}
		
	}

}
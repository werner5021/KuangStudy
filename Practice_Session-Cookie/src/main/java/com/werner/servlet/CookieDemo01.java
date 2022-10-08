package com.werner.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo01  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			out.write("上次拜訪時間為");
			for(int i=0; i<cookies.length; i++) {
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("lastLoginTime")) {
					long lastLoginTime= Long.parseLong(cookie.getValue());
					Date date = new Date(lastLoginTime);
					out.write(date.toLocaleString());
				}				
			}	
			
		}else {
			out.write("這是第一次拜訪");
		}
		Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
		cookie.setMaxAge(24*60*60);		
		resp.addCookie(cookie);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

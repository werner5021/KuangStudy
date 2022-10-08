package com.werner.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo03 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		Cookie[] cookies = req.getCookies();
		
		if(cookies != null) {
			out.write("上次造訪本站");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("name")) {
					String name = URLDecoder.decode(cookie.getValue(), "UTF-8");							
					out.write(name);
				}
			}
			
		}else {
			out.write("第一次造訪本站");
		}
		
		Cookie cookie = new Cookie("name", URLEncoder.encode("金智秀", "UTF-8"));
		cookie.setMaxAge(24*60*60);
		resp.addCookie(cookie);
		
		
		
	}
}

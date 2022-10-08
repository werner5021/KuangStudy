package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.werner.pojo.Person;

//顯示session的ID
public class SessionDemo01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.解決亂碼問題
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//2.得到Session
		HttpSession session = req.getSession();		
		
		//3.從Session中存東西
//		session.setAttribute("name", "李多斌");
		session.setAttribute("name", new Person("李多斌", 28));
		
		//4.獲取Session的ID
		String sessionId = session.getId();
		
		//5.判斷Session是否為新創建的
		if(session.isNew()) {
			resp.getWriter().write("Session創建成功, ID: "+ sessionId);
		}else {
			resp.getWriter().write("Session已經存在於伺服器中, ID: "+ sessionId);
		}	
		
		//Session創建成功時做了什麼事情
//		Cookie cookie = new Cookie("JSESSIONID", sessionId);
//		resp.addCookie(cookie);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

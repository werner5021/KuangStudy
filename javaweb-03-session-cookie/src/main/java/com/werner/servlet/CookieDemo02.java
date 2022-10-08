package com.werner.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//保存用戶上一次訪問的時間
public class CookieDemo02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//創建一個cookie，名字必須要和要刪除的名字一樣 (替換掉舊有的cookie)
		Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
		//cookie有效期設置為0
		cookie.setMaxAge(0);
		
		resp.addCookie(cookie);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

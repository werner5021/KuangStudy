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
public class CookieDemo01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//伺服器告訴你，你訪問的時間，把這個時間封裝成一個"信件"，你下次帶來，我就知道
		
		//解決中文亂碼
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//返回一些輸出字串
		PrintWriter out = resp.getWriter();		
		
		//Cookie，伺服器端從客戶端獲取:
		Cookie[] cookies = req.getCookies();  //這裡返回陣列，代表Cookie可能存在多個
		
		//判斷Cookie是否存在
		if(cookies != null) {
			//如果cookies存在怎麼辦
			out.write("您上一次訪問的時間是");
			
			for(int i=0; i<cookies.length; i++) {
				Cookie cookie = cookies[i];
				//獲取cookie的名字
				if(cookie.getName().equals("lastLoginTime")) {
					//獲取cookie中的值
					long lastLoginTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastLoginTime);
					out.write(date.toLocaleString());
				}				
			}			
		}else {
			out.write("這是您第一次訪問本站");
		}
		
		//伺服器給客戶響應一個cookie
		Cookie cookie = new Cookie( "lastLoginTime", System.currentTimeMillis()+"");
		
		//cookie有效期為一天
		cookie.setMaxAge(24*60*60);  //以秒為單位
		
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}	
}

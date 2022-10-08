package com.werner.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//中文數據怎麼傳遞
public class CookieDemo03 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
				if(cookie.getName().equals("name")) {
					//解碼
					out.write(URLDecoder.decode(cookie.getValue(),"UTF-8"));
//					out.write(cookie.getValue());					
				}				
			}			
		}else {
			out.write("這是您第一次訪問本站");
		}
		
		//編碼
		Cookie cookie = new Cookie("name", URLEncoder.encode("李知恩","UTF-8"));  //有中文的時候最好使用URLEncoder
//		Cookie cookie = new Cookie("name", "李知恩");
		resp.addCookie(cookie);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}

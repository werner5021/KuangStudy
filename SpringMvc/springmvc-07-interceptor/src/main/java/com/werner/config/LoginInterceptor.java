package com.werner.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

//在登入之前攔截，確認能否放行
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		//放行: 判斷什麼情況下登入了
		
		//登入頁面也會放行
		if(request.getRequestURI().contains("goLogin")) {  //如果請求裡面有Login，
			return true;
		}
		
		//說明我在提交登入
		if(request.getRequestURI().contains("login")) {  //如果請求裡面有Login，
			return true;
		}
		
		//第一次登入也是沒有Session
		if(session.getAttribute("userLoginInfo") != null) {
			return true;
		}
		
		//判斷什麼情況下沒有登入
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		return false;
	}

	
	
	
}

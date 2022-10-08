package com.werner.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	//Filter裡必須重寫doFilter()方法，攔截器裡面則沒有強制要重寫
	
	//return true: 執行下一個攔截器，放行
	//return flase: 不執行下一個攔截器
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("==========處理前==========");
		return true;
	}

	//用來處理攔截log
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("==========處理後==========");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("==========清理==========");
	}

	
	
	
	
	
	
}

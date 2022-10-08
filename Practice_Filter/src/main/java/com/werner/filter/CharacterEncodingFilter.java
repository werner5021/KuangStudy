package com.werner.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	//初始化: web服務器啟動就初始化了，隨時等待過濾對象
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CharacterEncodingFilter 初始化");
	}
	/*
	 * 1. 過濾器中的所有代碼，在過濾特定請求的時候都會執行
	 * 2. 必須要讓過濾器繼續通行
	 * 	  chain.doFilter(request, response);
	 * 3. 
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("CharacterEncodingFilter 執行前...");
		chain.doFilter(request, response);  //鏈是一種轉接，讓請求繼續執行，如果不寫，程序到這裡就被攔截停止
		System.out.println("CharacterEncodingFilter 執行後...");
	}
	//銷毀: web服務器關閉時，過濾器銷毀
	@Override
	public void destroy() {
		System.out.println("CharacterEncodingFilter 銷毀");
	}
}

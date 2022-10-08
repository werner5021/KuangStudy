package com.werner.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.werner.util.Constant;

//使用過濾器判斷用戶是否帶有session，沒有就導向錯誤頁面
public class SysFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		/*
		  if(request.getSession().getAttribute(Constant.USER_SESSION).Level == VIP1){
		  	response.sendDirect("/vip1/index.jsp");
		  }
		  if(request.getSession().getAttribute(Constant.USER_SESSION).Level == VIP2){
		  	response.sendDirect("/vip2/index.jsp");
		  }
		 */
		//Filter的ServletRequest是父層
		//HttpServlet的HttpServletRequest是子層
		//強制轉換
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		if(request.getSession().getAttribute(Constant.USER_SESSION) == null) {
			response.sendRedirect("/javaweb-05-filter/error.jsp");
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}

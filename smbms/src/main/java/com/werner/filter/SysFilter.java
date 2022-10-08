package com.werner.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.werner.pojo.User;
import com.werner.util.Constants;

public class SysFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//過濾器，從Session中獲取用戶
		User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
		
		if(user == null) {  //已經被 移除or註銷or未登入
			response.sendRedirect(request.getContextPath()+"/login.jsp");  //"smbms/error.jsp"
		}else {
			chain.doFilter(req, resp);
		}	
	}	
}

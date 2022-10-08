package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.werner.util.Constant;

public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//銷毀時不建議銷毀session，頻繁的創建銷毀session很消耗資源
		//銷毀attribute就好
		Object user_session = req.getSession().getAttribute(Constant.USER_SESSION);
		//如果Session裡的Attribute不為空，移除掉attribute，再重新導向
		if(user_session != null) {
			req.getSession().removeAttribute(Constant.USER_SESSION);
			resp.sendRedirect("/javaweb-05-filter/Login.jsp");
		}else {
			resp.sendRedirect("/javaweb-05-filter/Login.jsp");
		}		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
}

package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.werner.util.Constant;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//獲取前端請求的參數
		String username = req.getParameter("username");
		
		if(username.equals("admin")) {  //登入成功
			req.getSession().setAttribute(Constant.USER_SESSION, req.getSession().getId());  //放進Session裡面，才能在多個頁面取到
//			req.getRequestDispatcher("/sys/success.jsp").forward(req, resp);
			resp.sendRedirect("/javaweb-05-filter/sys/success.jsp");  //如果直接轉發就會拿不到數據，但是上面有加入session，所以可以拿的到			
		}else {    //登入失敗
			resp.sendRedirect("/javaweb-05-filter/error.jsp");
		}		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

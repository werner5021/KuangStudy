package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.獲取前端參數
		String method = req.getParameter("method");
		if(method.equals("add")) {
			req.getSession().setAttribute("msg", "執行了add方法");
		}else if(method.equals("delete")) {
			req.getSession().setAttribute("msg", "執行了delete法");			
		}		
		//2.調用業務層
		
		//3.視圖轉發or重定向
		req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

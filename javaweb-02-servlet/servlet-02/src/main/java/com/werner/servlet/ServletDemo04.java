package com.werner.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//轉發
public class ServletDemo04 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("進入了ServletDemo04");
		
		ServletContext context = this.getServletContext();
//		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp"); //轉發的請求路徑，這裡只有定址，沒有動作
//		requestDispatcher.forward(req, resp);  //調用forward實現請求轉發		
		context.getRequestDispatcher("/gp").forward(req, resp);
	}
}

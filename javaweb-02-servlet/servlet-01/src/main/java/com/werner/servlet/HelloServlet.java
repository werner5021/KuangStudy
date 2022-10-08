package com.werner.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	//由於get或post只是請求實現的不同方式，可以相互調用邏輯都一樣

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello");
		PrintWriter writer = resp.getWriter();  //響應流
		//req.getReader();       
		//req.getInputStream();   
		//ServletOutputStream outputStream = resp.getOutputStream();  //IO流分兩種，有writer就會有stream

		writer.print("Hello, Servlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

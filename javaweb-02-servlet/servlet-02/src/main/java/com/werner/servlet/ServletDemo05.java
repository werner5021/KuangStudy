package com.werner.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo05 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties"); // 把資源變成流

		Properties prop = new Properties();
		prop.load(is);

		String name = prop.getProperty("username");
		String pds = prop.getProperty("password");

		resp.getWriter().print(name + ":" + pds);

	}
}

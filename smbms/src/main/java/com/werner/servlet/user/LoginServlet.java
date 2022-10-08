package com.werner.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.werner.pojo.User;
import com.werner.service.user.UserService;
import com.werner.service.user.UserServiceImpl;
import com.werner.util.Constants;

public class LoginServlet extends HttpServlet{

	//Servlet: 控制層，調用業務層代碼	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入 LoginServlet...");
		
		//獲取用戶名、密碼 (從前端login.jsp傳來的)
		String userCode = req.getParameter("userCode");
		String userPassword = req.getParameter("userPassword");
		
		//和數據庫中的密碼進行對比，調用業務層
		UserService userService = new UserServiceImpl();
		User user = userService.login(userCode, userPassword);  //這裡已經把登入的人查出來
		
		if(user != null) {  //查有此人，可以登入
			//登入成功會將用戶的訊息，放入Session，以便後續取用
			req.getSession().setAttribute(Constants.USER_SESSION, user);
			//跳轉到內部頁面
			resp.sendRedirect("jsp/frame.jsp");			
		}else {  //查無此人，無法登入
			//轉發回登入頁面，順便提示用戶名或密碼錯誤
			req.setAttribute("error", "用戶名或密碼不正確");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

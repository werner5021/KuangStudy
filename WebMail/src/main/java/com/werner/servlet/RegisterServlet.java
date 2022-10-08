package com.werner.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.werner.pojo.User;
import com.werner.util.SendMail;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//接收用戶的請求，封裝成對象
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			
			User user = new User(username, password, email);
			
			//用戶註冊成功之後，給用戶發送一封郵件
			//我們使用線程來專們發送郵件，防止出現耗時、網站註冊人數過多的情況
			SendMail send = new SendMail(user);
			//啟動線程，線程啟動後就執行run()方法來發送郵件
			send.start();

			//註冊用戶
			req.setAttribute("message", "註冊成功，我們已發送一封和註冊訊息的電子郵件給你");
			req.getRequestDispatcher("info.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("message", "註冊失敗");
			req.getRequestDispatcher("info.jsp").forward(req, resp);
		}


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

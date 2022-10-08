package com.werner.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {

	//驗證用戶名、密碼、正常作法是pojo裡面寫實體類
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password, Model model) {  
		
		System.out.println("login==>"+username);
		
		//把用戶的訊息，存在Session中
		session.setAttribute("userLoginInfo", username);  //存在session後，跳轉到成功頁面		
		model.addAttribute("username",username);  //把username傳給前端
		return "main";  //登入頁面		
		//因為login.jsp、main.jsp無法直接訪問，我們從index.jsp入口頁過去
	}
	
	//註銷
	@RequestMapping("/goOut")
	public String goOut(HttpSession session) {  

		session.removeAttribute("userLoginInfo"); 	//移除節點
//		session.invalidate();  //移除Session也可以，但會頻繁向後端交換，不建議使用
		return "main";  //登入頁面		
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	@RequestMapping("/goLogin")
	public String login() {
		return "login";
	}
	
}

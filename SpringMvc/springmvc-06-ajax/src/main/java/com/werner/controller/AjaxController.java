package com.werner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.werner.pojo.User;

@RestController
public class AjaxController {

	@RequestMapping("/t1")
	public String test() {
		return "hello";
	}
	
	@RequestMapping("/a1")
	public void a1(String name, HttpServletResponse response) throws IOException {
		System.out.println("a1:param=>" + name);
		
		if("jisoo".equals(name)) {
			response.getWriter().print("true");
		}else {
			response.getWriter().print("false");
		}
	}
	
	@RequestMapping("/a2")  
	public List<User> a2(){  //這裡如果沒有導入jackson的包會406
		List<User> userList = new ArrayList<User>(); 
		//添加數據
		userList.add(new User("周子瑜", 23, "女"));
		userList.add(new User("平井桃", 25, "女"));
		userList.add(new User("湊崎紗夏", 25, "女"));
		
		return userList;  //現在這個做法不是異步
	}	
	
	
	@RequestMapping("/a3")
	public String a3(String name, String pwd){  //請求會返回成功或失敗
		String msg="";
		if(name!=null) {			
			//admin 這些數據應該在數據庫中查
			if("admin".equals(name)) {
				msg="用戶正確";
			}else {
				msg="用戶名有誤";
			}
		}
		if(pwd!=null) {			
			//admin 這些數據應該在數據庫中查
			if("123456".equals(pwd)) {
				msg="密碼正確";
			}else {
				msg="密碼有誤";
			}
		}
		return msg;		
	}
}

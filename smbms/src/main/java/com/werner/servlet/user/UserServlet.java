package com.werner.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import com.werner.pojo.Role;
import com.werner.pojo.User;
import com.werner.service.role.RoleService;
import com.werner.service.role.RoleServiceImpl;
import com.werner.service.user.UserService;
import com.werner.service.user.UserServiceImpl;
import com.werner.util.Constants;
import com.werner.util.PageSupport;

//實現Servlet復用
public class UserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//判斷前端pwdmodify.do傳過來的值
		String method = req.getParameter("method");
		if(method.equals("savepwd") && method != null) {
			this.updatePwd(req, resp);
		}else if (method.equals("pwdmodify") && method != null) {
			this.pwdModify(req, resp);
		}else if (method.equals("query") && method != null) {
			this.query(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}	
	
	//修改密碼
	public void updatePwd(HttpServletRequest req, HttpServletResponse resp) {		
		//從Session裡面拿id，這裡先不轉型態，等確認是對的再轉，代碼優化
		Object obj = req.getSession().getAttribute(Constants.USER_SESSION);		
		
		String newpassword = req.getParameter("newpassword");

		System.out.println("UserServlet 新密碼為:" + newpassword);  //test用

		boolean flag = false;  //用flag判斷修改是否成功

      //if(obj != null && newpassword != null) {}  也可以這樣寫
		if(obj != null && !StringUtils.isNullOrEmpty(newpassword)) {  //不為空，長度也不為0，代表有這個人
			UserService userService = new UserServiceImpl();
			flag = userService.updatePwd(((User) obj).getId(), newpassword);
			if(flag) {
				req.setAttribute("message", "修改密碼成功，請退出後重新登入");
				//密碼修改成功，移除當前Session
				req.getSession().removeAttribute(Constants.USER_SESSION);
				//這裡不用重新導回登入頁，因為在過濾器裡有做了
			}else {
				req.setAttribute("message", "修改密碼失敗");
			}
		}else {
			req.setAttribute("message", "新密碼有問題");
		}
		try {
			req.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//驗證密碼，session中有用戶的密碼，不用再寫一條線到數據庫去拿
	public void pwdModify(HttpServletRequest req, HttpServletResponse resp) {
		
		//從Session裡面拿id，這裡先不轉型態，等確認是對的再轉，代碼優化
		Object obj = req.getSession().getAttribute(Constants.USER_SESSION);				
		String oldpassword = req.getParameter("oldpassword");  //pwdmodify.js 第20行，不是jsp裡的
		
		//萬能的Map: 原本的結果集resultSet
		Map<String, String> resultMap = new HashMap<String, String>();
		
		if(obj == null) {  //session失效、過期
			resultMap.put("result", "sessionerror");
		}else if(StringUtils.isNullOrEmpty(oldpassword)){  //舊密碼為空
			resultMap.put("result", "error");
		}else {
			String userPassword = ((User) obj).getUserPassword();  //Session中用戶的密碼
			if(oldpassword.equals(userPassword)) {  //密碼正確
				resultMap.put("result", "true");
			}else {
				resultMap.put("result", "false");
			}
		}		
		
		try {
			resp.setContentType("application/json");  //返回一個json值
			PrintWriter writer = resp.getWriter();
			//JSONArray 阿里巴巴的JSON工具，用來轉換格式
			/*
			 * resultMap = ["result","sessionerror","result","error"]
			 * JSON格式 = {key : value}
			 */
			writer.write(JSONArray.toJSONString(resultMap));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//重點，難點
	public void query(HttpServletRequest req, HttpServletResponse resp) {
		
		//查詢用戶列表
		//從前端獲取數據
		String queryUserName = req.getParameter("queryname");
		String temp = req.getParameter("queryUserRole");
		String pageIndex = req.getParameter("pageIndex");
		int queryUserRole = 0;
		
		//獲取用戶列表
		UserServiceImpl userService = new UserServiceImpl();
		List<User> userList = null;  //獲取用戶列表需要許多參數，所以底下先準備參數
		
		//第一次走這個請求，一定是第一頁，頁面大小固定
		int pageSize = 5; //可以把這個寫到配置文件中，方便後期修改
		int currentPageNo = 1;
		
		if(queryUserName == null) {
			queryUserName = "";  //查詢的名字為空，要手動賦值
		}
		if(temp != null && !temp.equals("")) {  
			//如果甚麼都沒選默認為空，在這裡判斷空會出錯，所以要先賦值為0
			//临时变量就是真正的值 最终使用的值是queryUserRole 如果真正的值是空的那就值为0 不是空的再给它真的值
			//前端返回的为String类型可能为null，着了判断并转换为int
			queryUserRole = Integer.parseInt(temp);  //給查詢賦值 0,1,2,3
		}
		if(pageIndex != null) {
			currentPageNo = Integer.parseInt(pageIndex);  //默認是第一頁，萬一翻頁就看前端傳回來的index值
		}
		
		//獲取用戶的總數(分頁: 上一頁、下一頁)
		int totalCount = userService.getUserCount(queryUserName, queryUserRole);
		//總頁數支持
		PageSupport pageSupport = new PageSupport();
		pageSupport.setCurrentPageNo(currentPageNo);  //設置當前頁碼
		pageSupport.setPageSize(pageSize);  //設置頁面容量
		pageSupport.setTotalCount(totalCount);  //
		
//		int totalPageCount = ((int)(totalCount/pageSize))+1;  //總共有幾頁，這是不用工具的寫法
		pageSupport.setTotalPageCountByRs();
		int totalPageCount = pageSupport.getTotalPageCount();
		
		//控制首頁和尾頁		
		if(totalPageCount<1) {  ////如果頁面要小於1，就顯示第1頁
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount) {  //當前頁面大於最後一頁
			currentPageNo = totalPageCount;
		}
		
		//獲取用戶列表展示
		userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
		req.setAttribute("userList", userList);
		//拿角色列表
		RoleService roleService = new RoleServiceImpl();
		List<Role> roleList = roleService.getRoleList();
		req.setAttribute("roleList", roleList);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("currentPageNo", currentPageNo);
		req.setAttribute("totalPageCount", totalPageCount);
		req.setAttribute("queryUserName", queryUserName);
		req.setAttribute("queryUserRole", queryUserRole);		
		
		//返回前端
		try {
			req.getRequestDispatcher("userlist.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}


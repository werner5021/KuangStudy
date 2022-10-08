package com.werner.service.user;

import java.util.List;

import com.werner.pojo.User;

public interface UserService {
	//用戶登入(使用帳號、密碼判斷)
	public User login(String userCode, String userPassword);
	
	//根據用戶id修改密碼，是否修改成功直接用boolean，不用原本的int
	public boolean updatePwd(int id, String pwd);
	
	
	//查詢紀錄數
	public int getUserCount(String userName, int userRole);
	
	 /**
     * 根据条件查询用户列表
     *
     * @param queryUserName
     * @param queryUserRole
     * @return
     */
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
}

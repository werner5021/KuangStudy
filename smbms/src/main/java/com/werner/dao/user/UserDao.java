package com.werner.dao.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.werner.pojo.Role;
import com.werner.pojo.User;

//設置為面向接口編程
public interface UserDao {	
	//得到要登入的用戶 (數據庫連接對象、userCode)
	public User getLoginUser(Connection connection, String userCode) throws SQLException;
	
	//修改當前用戶密碼
	public int updatePwd(Connection connection, int id, String password) throws SQLException;
	
	//查詢用戶總數
	public int getUserCount(Connection connection, String userName, int userRole) throws SQLException;

	//通過條件查詢用戶 userList
	public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)throws SQLException;

	
}

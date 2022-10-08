package com.werner.service;

import com.werner.dao.UserDao;
import com.werner.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService {

//	private UserDao userDao = new UserDaoImpl();
//	private UserDao userDao = new UserDaoMysqlImpl();
//	private UserDao userDao = new UserDaoOracleImpl();  //每一次因為用戶的請求，代碼要做改動 
	
	private UserDao userDao;
	
	//利用set進行動態實現值的注入
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void getUser() {
		userDao.getUser(); 
		
	}
	
	

}

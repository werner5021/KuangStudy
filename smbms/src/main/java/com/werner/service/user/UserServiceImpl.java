package com.werner.service.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.werner.dao.BaseDao;
import com.werner.dao.user.UserDao;
import com.werner.dao.user.UserDaoImpl;
import com.werner.pojo.User;

public class UserServiceImpl implements UserService {

	//業務層都會調用Dao層，所以我們要引入Dao層
	private UserDao userDao;	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();  //new UserServiceImpl的時候，userDao就實體化
	} 
		
	@Override
	public User login(String userCode, String userPassword) {
		
		Connection connection = null;  //要用connection去調Dao層
		User user = null;		
		
		try {
			connection = BaseDao.getConnection();  //獲取connection
			//通過業務層調用對應的具體的數據庫操作
			user = userDao.getLoginUser(connection, userCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeResources(connection, null, null);
		}
		return user;  //只要調用login()方法的人，就能獲得該用戶user
	}	
	
	@Test
	public void test() {
		UserServiceImpl userService = new UserServiceImpl();
		User admin = userService.login("admin", "123456");
		System.out.println(admin.getUserPassword());
	}

	@Override
	public boolean updatePwd(int id, String pwd) {
		System.out.println("UserServiceImpl 新密碼為:" + pwd);
		
		//業務層存在事務，執行失敗會回滾，所以Connection創建在業務層		
		Connection connection = null;		
		boolean flag = true;
		//修改密碼
		try {
			connection = BaseDao.getConnection();
			if(userDao.updatePwd(connection, id, pwd)>0) {
				flag = true;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeResources(connection, null, null);
		}
		return flag;
	}

	//查詢紀錄數
	public int getUserCount(String userName, int userRole) {
		
		Connection connection = null;	
		int count = 0;		
		connection = BaseDao.getConnection();
		try {
			count = userDao.getUserCount(connection, userName, userRole);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDao.closeResources(connection, null, null);
		}		
		return count;
	}
	
	@Test
	public void test1() {
		int userCount = new UserServiceImpl().getUserCount(null, 3);  //查所有管理員的數量
		System.out.println(userCount);
	}
	
	@Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<User> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResources(connection, null, null);
        }
        return userList;
    }

	
}

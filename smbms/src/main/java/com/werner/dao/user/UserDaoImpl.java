package com.werner.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;
import com.werner.dao.BaseDao;
import com.werner.pojo.Role;
import com.werner.pojo.User;

public class UserDaoImpl implements UserDao{
	
	//得到要登入的用戶 (數據庫連接對象、userCode)
	public User getLoginUser(Connection connection, String userCode) throws SQLException {
		System.out.println("進入 UserDaoImpl...");
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user =null;		

		//判斷數據庫連接是否成功
		if(connection != null) {
			//使用SQL語句查出登入的用戶
			String sql = "select * from smbms_user where userCode=?";
			Object[] params = {userCode};  //參數要封裝

			//獲得User的結果集
			rs = BaseDao.execute(connection, pstm, rs, sql, params );
			//使用結果集歷遍
			if(rs.next()) {
				user = new User(); //查出來的登入的用戶數據，封裝到用戶user裡面
				user.setId(rs.getInt("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setGender(rs.getInt("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setUserRole(rs.getInt("userRole"));
				user.setCreatedBy(rs.getInt("createdBy"));
				user.setCreationDate(rs.getTimestamp("creationDate"));
				user.setModifyBy(rs.getInt("modifyBy"));
				user.setModifyDate(rs.getTimestamp("modifyDate"));
			}
			//關閉數據
			BaseDao.closeResources(null, pstm, rs);  //連接到先不關，到事務的時候再處理
		}		
		return user;
	}
	
	//修改當前用戶密碼
	public int updatePwd(Connection connection, int id, String password) throws SQLException{
		
		System.out.println("UserDaoImpl 新密碼為:" + password);
		
		PreparedStatement pstm = null;  //執行的對象，用來執行預編譯
		int execute = 0;
		
		if(connection != null) {			
			String sql="update smbms_user set userPassword=? where id=?";
			Object[] params = {password, id};  //把參數值接封裝成陣列丟入
			execute = BaseDao.execute(connection, pstm, sql, params);
			BaseDao.closeResources(null, pstm, null);
		}		
		return execute;
	}

	
	//根據用戶名or角色，查詢用戶總數
	public int getUserCount(Connection connection, String userName, int userRole) throws SQLException {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		
		if(connection != null) {
			StringBuffer sql = new StringBuffer();  //這裡要使用SQL的拼接
			sql.append("select count(1) as count from smbms_user u, smbms_role r where u.userRole = r.id");
			ArrayList<Object> list = new ArrayList<Object>();  //存放我們 的參數，因為不知道用什麼，就設定Object
						
			if(!StringUtils.isNullOrEmpty(userName)) {
				sql.append(" and u.userName like ?");
				list.add("%"+ userName +"%");  //list默認index:0
			}
			if(userRole > 0) {
				sql.append(" and u.userRole = ?");
				list.add(userRole); //list默認index:1
			}
			
			//如何把list轉換為陣列
			Object[] params = list.toArray();
			
			System.out.println("UserDaoImpl--> getUserCount:"+sql.toString());  //輸出完整的sql語句
			
			rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
			
			if(rs.next()) {
				count = rs.getInt("count");  //從結果集中獲取最終的數量，count是前面在sql語法中自訂的欄位
			}
			BaseDao.closeResources(null, pstm, rs);
		}
		return count;
	}

	/*
	 * 要自己寫過
	 */
	@Override
	public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)
			throws SQLException {
		 PreparedStatement pstm = null;
	        ResultSet rs = null;
	        List<User> userList = new ArrayList<User>();
	        if(connection != null){
	            StringBuffer sql = new StringBuffer();
	            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
	            List<Object> list = new ArrayList<Object>();
	            if(!StringUtils.isNullOrEmpty(userName)){
	                sql.append(" and u.userName like ?");
	                list.add("%"+userName+"%");
	            }
	            if(userRole > 0){
	                sql.append(" and u.userRole = ?");
	                list.add(userRole);
	            }

	            //在数据库中，分页使用 limit startIndex pageSize
	            //当前页  （当前页-1）*页面大小
	            //0,5    1   0    01234
	            //6,5    2   5    56789
	            //11,5   3   10
	            sql.append(" order by creationDate DESC limit ?,?");
	            currentPageNo = (currentPageNo-1)*pageSize;
	            list.add(currentPageNo);
	            list.add(pageSize);

	            Object[] params = list.toArray();
	            System.out.println("sql ----> " + sql.toString());
	            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
	            while(rs.next()){
	                User _user = new User();
	                _user.setId(rs.getInt("id"));
	                _user.setUserCode(rs.getString("userCode"));
	                _user.setUserName(rs.getString("userName"));
	                _user.setGender(rs.getInt("gender"));
	                _user.setBirthday(rs.getDate("birthday"));
	                _user.setPhone(rs.getString("phone"));
	                _user.setUserRole(rs.getInt("userRole"));
	                _user.setUserRoleName(rs.getString("userRoleName"));
	                userList.add(_user);
	            }
	            BaseDao.closeResources(null, pstm, rs);
	        }
	        return userList;
	}
	
}

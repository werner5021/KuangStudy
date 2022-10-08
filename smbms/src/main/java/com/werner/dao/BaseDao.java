package com.werner.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//操作數據庫的公共類
public class BaseDao {
	
	//獲取連接需要的變量
	private static String driver;
	private static String url;
	private static String user;
	private static String password;	
	
	//靜態代碼塊，類加載的時候就初始化 -> 獲取配置文件的內容
	static {
		Properties properties = new Properties();
		//通過類加載器讀取對應的資源
		InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
		
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");	
	}
	
	//獲取數據庫的連接
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(driver);  //加載驅動
			connection = DriverManager.getConnection(url, user, password);  //獲取連接
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//編寫查詢公共方法(建立連結、執行sql、佔位填滿、返回結果)
	public static ResultSet execute(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String sql, Object[] params) throws SQLException {
		
		//1.獲得連接，預編譯的sql在後面直接執行就可以
		preparedStatement = connection.prepareStatement(sql);  //預編譯sql
		
		//2.往預編譯sql裡面設置值，如果有很多個參數，要歷遍
		//這裡還不知道sql裡面有幾個參數，我們使用變量代替參數，再歷遍執行
		for(int i=0; i<params.length; i++) {
			//setObject，佔位符從1開始，但陣列是從0開始
			preparedStatement.setObject(i+1, params[i]);
		}
		//3.佔位符號處理完，開始執行SQL
		resultSet = preparedStatement.executeQuery();  //查詢

		return resultSet;

		//這個方法只專注在編寫跟傳遞SQL語法，沒有執行其他操作
		//preparedStatement 跟 resultSet 的宣告，被提出去是為了統一關閉
	}

	//編寫增刪改公共方法
	public static int execute(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) throws SQLException {
		//改動之後，不用返回ResultSet，所以拿掉resultSet
		
		//1.獲得連接
		preparedStatement = connection.prepareStatement(sql);  //預編譯sql

		//2.往預編譯sql裡面設置值，如果有很多個參數，要歷遍
		//這裡還不知道sql裡面有幾個參數，我們使用變量代替參數，再歷遍執行
		for(int i=0; i<params.length; i++) {
			//setObject，佔位符從1開始，但陣列是從0開始
			preparedStatement.setObject(i+1, params[i]);
		}
		//3.佔位符號處理完，開始執行SQL，執行完返回int類型的值(常數)
		int updateRows = preparedStatement.executeUpdate();  //更新
		return updateRows;
	}
	
	//釋放資源
	public static boolean closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		boolean flag = true;
		
		if(resultSet != null) {
			try {
				resultSet.close();
				//關閉完萬一resultSet還存在，要讓GC回收
				resultSet = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//如果沒有成功關閉，用flag判別
				flag = false;
			}
		}
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
				//關閉完萬一resultSet還存在，要讓GC回收
				preparedStatement = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//如果沒有成功關閉，用flag判別
				flag = false;
			}
		}
		if(connection != null) {
			try {
				connection.close();
				//關閉完萬一resultSet還存在，要讓GC回收
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//如果沒有成功關閉，用flag判別
				flag = false;
			}
		}		
		//都釋放成功，就返回true
		return flag;	
	}

}

package com.werner.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//配置訊息
		//useUnicode=true&charset=utf8 解決中文亂碼\
		String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "12345678";
		
		//1.加載驅動
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.連接數據庫，代表數據庫
		Connection connection = DriverManager.getConnection(url, username, password);  
		//Connection 代表數據庫
		//DriverManager 驅動管理
		//connection.prepareStatement(sql); 預編譯，比較安全，先放sql
		
		//3.向數據庫發送SQL的對象 Statement, PrepareStatement : CRUD
		Statement statement = connection.createStatement();
				
		//4.編寫SQL
		String sql = "select * from users;";
		
		/*
		String sql1 = "delete from users where id=4";
		//受影響的行數，增刪改都使用executeUpdate
		int i = statement.executeUpdate(sql1);  
		*/
		
		//5.執行SQL(查詢)，返回一個ResultSet
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("id=" + rs.getObject("id"));
			System.out.println("name=" + rs.getObject("name"));
			System.out.println("password=" + rs.getObject("password"));
			System.out.println("email=" + rs.getObject("email"));
			System.out.println("birthday=" + rs.getObject("birthday"));
		}
		
		//6.關閉連接，釋放資源(一定要做)，先開後關
		rs.close();
		statement.close();
		connection.close();			
	}  
}

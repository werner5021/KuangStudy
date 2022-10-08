package com.werner.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC001 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		
//		String url= "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8";
//		String user = "root";
//		String password = "12345678";
//		Connection connection = null;
	
		
		String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=UTF8";
		String user = "root";
		String password="12345678";
		Connection connection = null;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into users(id, name, password) values (?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2, "全汝彬");
			preparedStatement.setString(3, "112233");
			
			int i = preparedStatement.executeUpdate();
			if(i>0) {
				System.out.println("YES");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
}

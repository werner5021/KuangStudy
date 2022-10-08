package com.werner.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;


public class TestJDBC2 {
	public static void main(String[] args) throws Exception {
		//配置訊息
		//useUnicode=true&charset=utf8 解決中文亂碼\
		String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "12345678";
		
		//1.加載驅動
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.連接數據庫，代表數據庫
		Connection connection = DriverManager.getConnection(url, username, password);  
		
		//3.編寫SQL
		String sql = "insert into users(id, name, password, email, birthday) values (?,?,?,?,?);";		
				
		//4.預編譯 PrepareStatement : CRUD
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, 4);  //給第一個佔位符"?"賦值為4
		preparedStatement.setString(2, "朴寶英");  //給第二個佔位符"?"賦值為"朴寶英"
		preparedStatement.setInt(3, 123456);  //給第三個佔位符"?"賦值為123456
		preparedStatement.setString(4, "bobo@gmail.com");  //給第四個佔位符"?"賦值為"bobo@gmail.com"
		preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));  //給第五個佔位符"?"賦值為...
		
		//5.執行SQL
		int i = preparedStatement.executeUpdate();
		
		if(i>0){
			System.out.println("插入成功");
		}
				
		//6.關閉連接，釋放資源(一定要做)，先開後關		
		preparedStatement.close();
		connection.close();			
	} 
}

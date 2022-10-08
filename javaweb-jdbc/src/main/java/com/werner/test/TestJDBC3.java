package com.werner.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class TestJDBC3 {
	// Junit的測試用法，可以不用透過main()來呼叫類別的方法
//	@Test
//	public void test() {
//		System.out.println("Hello");
//	}	
//	@Test
//	public void test1() {
//		System.out.println(1/0);
//	}	
    @Test
	public void test() {
		// 配置訊息
		// useUnicode=true&charset=utf8 解決中文亂碼\
		String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "12345678";
		
		Connection connection = null;		

		// 1.加載驅動
		try {
			Class.forName("com.mysql.jdbc.Driver");
		

		// 2.連接數據庫，代表數據庫
		connection = DriverManager.getConnection(url, username, password);

		//3.通知數據庫開啟事務，false為開啟、true為關閉
		connection.setAutoCommit(false); 
		
		String sql = "update account set money = money-100 where name='A';";
		connection.prepareStatement(sql).executeUpdate();
		
		//製造錯誤
//		int i =1/0;
		
		String sql2 = "update account set money = money+100 where name='B';";
		connection.prepareStatement(sql2).executeUpdate();
		
		connection.commit(); //以上兩條SQL都執行成功，就提交事務
		System.out.println("提交成功");
		
		} catch (Exception e) {
			try {
				//如果出現異常，就通知數據庫回滾
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package com.zzgproject.file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class MySqlConnect {
	
	
	public static Connection getConnection(){
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/ht?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			conn = DriverManager.getConnection(url , user , password ) ;
			
			Statement stm = conn.createStatement();
			String sql = "select ";
			System.out.println(conn);
			
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		return null;
	}
}

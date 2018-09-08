package com.util;


import java.sql.*;

public class Conn {
	static String url = "jdbc:mysql://localhost:3306/test_students?useSSL=false";
	static String username = "root";
	static String password = "123";
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	
	public static void init() {
		
				try {
					Class.forName("com.mysql.jdbc.Driver");
					 conn = DriverManager.getConnection(url,username,password);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			    
	}
	public static int addUpdDel (String sql) {
		
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
		 i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	public static ResultSet selectSql(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

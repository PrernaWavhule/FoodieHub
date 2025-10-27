package com.prerna.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

	private static Connection con = null;
	
	public static Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3306/foodiehub";
		String un = "root";
		String pwd = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,un,pwd);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}

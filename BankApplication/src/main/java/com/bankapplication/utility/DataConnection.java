package com.bankapplication.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
 public Connection connect() {
	 Connection con =null;
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","Shravani","Smiley@97");

	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
		
 }
}

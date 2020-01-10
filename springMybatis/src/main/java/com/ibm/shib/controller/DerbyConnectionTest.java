package com.ibm.shib.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyConnectionTest {

	Connection conn = null;
	 Statement stmt;
	 ResultSet rs;
	String URL;
	String Username;
	String Password;

	public void SQLConnect() {
	        try {
	            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	        }
	        catch (ClassNotFoundException e){
	            System.out.println(e.toString());
	        }
	        System.out.println("Created SQL Connect");
	    }

	public void CreateConnection() {
		try {
			URL = "jdbc:derby:mybatisdb;create=true";
			//Conn = DriverManager.getConnection(URL);
			 //URL = "jdbc:derby://localhost:1527/mybatisdb";
			 conn = DriverManager.getConnection(URL);
			 System.out.println("Successfully Connected");
			 
			 
			 String sql="Select * from mybatisdb.employee";
		    stmt  = conn.createStatement();
		    System.out.println("Statement created....");
		    stmt.executeQuery(sql);
		    
		    System.out.println("Qurty executed..preoperly");
		    
		        rs = stmt.getResultSet();
		     System.out.println("Result set return.. properly");
		     while(rs.next()) {
		    	 System.out.println(rs.getString("fullname"));
		     }
		        
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	public void CloseConnection() {
		try {
			this.conn.close();
			System.out.println("Connection successfully closed");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String args[]) {
		DerbyConnectionTest sql = new DerbyConnectionTest();
		sql.CreateConnection();
		sql.CloseConnection();
	}
}

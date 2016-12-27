package com.iitworkforce.javatraining;

import java.sql.*;
import com.iitworkforce.javatraining.MusicTeacher;

public  class DAO
{
	private static Connection conn = null;
	
	public static Connection getDAO()
	{
		// Connection String can be instance variable - private static final String 
	try
	{
		String URL = "jdbc:mysql://localhost/javaproject";
		Class.forName("com.mysql.jdbc.Driver"); // Declare outside
		conn= DriverManager.getConnection(URL,"root","aarush10");
		// Also try JNDI approach. I will give you video for JNDI
	}
	catch(Exception e)
	{
		// Exception handling - do you need Video for this?
	}
	return conn;
	}
	
	// Add a method to close the connection
}

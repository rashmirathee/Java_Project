package com.iitworkforce.javatraining;

import java.sql.*;
import com.iitworkforce.javatraining.MusicTeacher;

public  class DAO
{
	static Connection conn = null;
	
	public static Connection getDAO()
	{
			
	try
	{
		String URL = "jdbc:mysql://localhost/javaproject";
		Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection(URL,"root","aarush10");
	}
	catch(Exception e)
	{
		
	}
	return conn;
	}
}
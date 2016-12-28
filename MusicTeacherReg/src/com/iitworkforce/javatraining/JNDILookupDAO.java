package com.iitworkforce.javatraining;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.NamingException;
import java.sql.SQLException;




public class JNDILookupDAO

{
	
	
	public static Connection getConnection()
	{
		Context ctx = null;
		Connection conn = null;
		
		try{
			ctx = new InitialContext();
			
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyDB");
			
			conn = ds.getConnection();
		}
		catch(NamingException e)
		{
			System.out.println("**************NamingException in JNDILookupDAO" + e.getMessage());
		} 
		catch (SQLException e)
		{
			System.out.println("***************SQLException in JNDILookupDAO" + e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("********************Exception in JNDILookupDAO" + e.getMessage());
		}
		
		return conn;
	}
}


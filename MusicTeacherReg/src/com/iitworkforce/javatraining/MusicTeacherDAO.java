package com.iitworkforce.javatraining;

import java.sql.*;
import com.iitworkforce.javatraining.MusicTeacher;

public class MusicTeacherDAO
{
	 static Connection con = DAO.getDAO(); // Conection cannot be at class level. 
	

	public static int save(MusicTeacher mt)
	{
		int status = 0;
			
	try
	{
		// Get the connection here and close it in finally 
		String sql = "INSERT INTO music_school_teacher values(?,?,?,?,?,?,?,?)"; // get it outside. as Final String
		PreparedStatement ps = con.prepareStatement(sql);
		int i = addNewID(); // addNewId() supressed exceptions, so code doesnt know wheather it received a new ID
		ps.setInt(1,i );
		ps.setString(2,mt.getFname() );
		ps.setString(3,mt.getLname() );
		ps.setString(4,mt.getMusictype() );
		ps.setString(5,(mt.getYearsofexp()) );
		ps.setString(6,mt.getEmail() );
		ps.setString(7,(mt.getPhonenumber()) );
		ps.setString(8,(mt.getAltnumber()) );
		
		status = ps.executeUpdate();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		// Never supress any exception in inner layers
	}  
	    return status; 
	}
	// Can we just use autoincrement at Table Level. Please try that.
	public static int addNewID() {  

		int id=0;

		         try 
		         {  
		        	   
				
		               String sql = "select max(TechId) from music_school_teacher;";  

		                PreparedStatement pst = con.prepareStatement(sql);  
		                ResultSet rs = pst.executeQuery() ;  

	                    while (rs.next())  
	                    {  

		                   id = (rs.getInt("TechId"))+1;  

		                 }  

		         } 
		         catch (Exception ex) 
		         {  
// handle - as commented in other code.
		         }  
		         
		         return id;

}
}

　

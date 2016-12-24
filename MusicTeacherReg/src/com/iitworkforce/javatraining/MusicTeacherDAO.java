package com.iitworkforce.javatraining;

import java.sql.*;
import com.iitworkforce.javatraining.MusicTeacher;

public class MusicTeacherDAO
{
	 static Connection con = DAO.getDAO();

	public static int save(MusicTeacher mt)
	{
		int status = 0;
			
	try
	{
		
		String sql = "INSERT INTO music_school_teacher values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		int i = addNewID();
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
	}  
	    return status; 
	}
	
	public static int addNewID() {  

		int id=0;

		         try 
		         {  
		        	   

		               String sql = "select TechId from music_school_teacher order by TechId  asc limit 1;";  

		                PreparedStatement pst = con.prepareStatement(sql);  
		                ResultSet rs = pst.executeQuery() ;  

	                    while (rs.next())  
	                    {  

		                   id = (rs.getInt("TechId"))+1;  

		                 }  

		         } 
		         catch (Exception ex) 
		         {  

		         }  
		         
		         return id;

}
}



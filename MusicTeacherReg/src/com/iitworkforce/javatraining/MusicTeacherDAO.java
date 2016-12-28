package com.iitworkforce.javatraining;
import java.sql.*;
import com.iitworkforce.javatraining.JNDILookupDAO;
import com.iitworkforce.javatraining.MusicTeacher;
public class MusicTeacherDAO 
{  //static Connection con = DAO.getDAO();      
  public static int save(MusicTeacher mt) 
  {  int status = 0;  Connection con = null; 
   PreparedStatement ps = null;   
   try {  
     con = JNDILookupDAO.getConnection(); 
     String sql = "INSERT INTO music_school_teacher(FirstName, LastName, Category, Experience, EmailId, CellNo, AltNo) values(?,?,?,?,?,?,?)"; 
     ps = con.prepareStatement(sql);    
     ps.setString(1,mt.getFname() );  
     ps.setString(2,mt.getLname() ); 
     ps.setString(3,mt.getMusictype() ); 
     ps.setString(4,(mt.getYearsofexp()) ); 
     ps.setString(5,mt.getEmail() );  
     ps.setString(6,(mt.getPhonenumber()) ); 
     ps.setString(7,(mt.getAltnumber()) );    
     status = ps.executeUpdate();   
   } 
   catch(SQLException e)
   { 
     System.out.println("SQL Exception in saving the details in  MusicTeacherDAO" + e.getMessage());
   }   
   catch(Exception e)
   { 
     System.out.println("Exception in  MusicTeacherDAO" + e.getMessage());
   }     
   finally
   {       
     if (ps != null)     
     {        
       try        
       {         
         ps.close();     
       }         
       catch (SQLException e)         
       {         
         System.out.println("SQL Exception in closing the prepared statement in MusicTeacherDAO" + e.getMessage());        
       }     
     }        
     if (con != null)    
     {        
       try       
       {           
         con.close();    
       }         
       
       catch (SQLException e)        
       {         
         System.out.println("SQL Exception in closing the connection in MusicTeacherDAO" + e.getMessage());        
       }     
     } 
   }  
   return status;
  }
}

package com.cswlearn.helper;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.validator.routines.EmailValidator;

public class TeacherregAction extends ActionSupport implements ModelDriven<MusicTeacher>
{  

  private MusicTeacher mt = new MusicTeacher();

   @Override 
	public String execute() 
	{     
		int i= MusicTeacherDAO.save(mt);
        if(i>0) {
			addActionMessage("You have successfully submitted your details.Thanks!");
			return SUCCESS;
		    }else {     addActionMessage("There was a connection problem in saving your details. Please try again later!");
     return INPUT;
    }        
    }  
	
	@Override 
  public void validate() 
  {    
    if(("").equals(mt.getFname()) || !mt.getFname().matches("^[A-Za-z, ]++$"))  
    {   
      addActionError( "Please enter First Name");

   }     if(("").equals(mt.getLname()) || !mt.getLname().matches("^[A-Za-z, ]++$"))  {   addActionError( "Please enter Last Name");

   }  if(("").equals(mt.getYearsofexp()) || !mt.getYearsofexp().matches("[0-9]+"))  {   addActionError( "Please enter years of experience");

    }  if(("-1").equals(mt.getMusictype()))  {   addActionError( "Please enter Music Category");

    }   if(("").equals(mt.getPhonenumber()) || (mt.getPhonenumber().length()!=10) || !mt.getPhonenumber().matches("[0-9]+"))  {   addActionError("Please enter a valid mobile number");

     }    if(("").equals(mt.getEmail()) || !(EmailValidator.getInstance().isValid(mt.getEmail())))  {   addActionError("Please enter a valid email");

    } }   @Override public MusicTeacher getModel() {         return mt;

 }}

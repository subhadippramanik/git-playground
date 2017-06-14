package com.col.data;

import java.sql.*;
import java.util.*;

import com.col.conn.DataConnection;
import com.col.lab.Login;

public class LoginDao {     
	 private Connection conn;

	 public LoginDao() {
		 conn = DataConnection.getConnection();
	 }
	
	 public List<Login> getAllLogins() {
		 List<Login> logins = new ArrayList<Login>();
		 try {
			 Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery("select * from muser order by UserName");
			 while (rs.next()) {
				 Login login = new Login();
				 
				 login.setUserId(rs.getInt("UserId"));
				 login.setFullName(rs.getString("FullName"));
				 login.setUserName(rs.getString("UserName"));
				 login.setUserPwd(rs.getString("UserPwd"));
				 login.setUserRole(rs.getString("UserRole"));
				 login.setIsActive(rs.getString("IsActive"));
				 login.setTemplatePath(rs.getString("templatepath"));
				 
				 logins.add(login);
			 }
		 } catch (SQLException e) {			 
			 e.printStackTrace();
		 }

		 return logins;
	}	 
	
	public Login getLoginByName(String username, String userpwd){ 
		Login login =  new Login();  
		try { 
	    	PreparedStatement preparedStatement = conn.
		    prepareStatement("select * from muser where UserName=? and UserPwd=?");
	    	preparedStatement.setString(1, username);
	    	preparedStatement.setString(2, userpwd);
	    	ResultSet rs = preparedStatement.executeQuery();		    		   
	    	if (rs.next()) {		    	
	    		 login.setUserId(rs.getInt("UserId"));
				 login.setFullName(rs.getString("FullName"));
				 login.setUserName(rs.getString("UserName"));
				 login.setUserPwd(rs.getString("UserPwd"));
				 login.setUserRole(rs.getString("UserRole"));
				 login.setIsActive(rs.getString("IsActive"));
				 login.setTemplatePath(rs.getString("templatepath"));		  
	    	}	  	    	  
      } catch(Exception e){e.printStackTrace();
      } 
	  return login;
    }
	
	public int validateLogin(String username, String userpwd){	      
	    int validLogin = 0;	   	
	   	try { 
		    	PreparedStatement preparedStatement = conn.
    		    prepareStatement("select count(*) as mCnt from muser where UserName=? and UserPwd=?");
		    	preparedStatement.setString(1, username);
		    	preparedStatement.setString(2, userpwd);
		    	ResultSet rs = preparedStatement.executeQuery();		    		   
		    	if (rs.next()) {		    	
	    			  validLogin = rs.getInt("mCnt");	    		  
		    	}	  	    	  
	      } catch(Exception e){e.printStackTrace();
	      } 
	      return validLogin; 
	   } 
}
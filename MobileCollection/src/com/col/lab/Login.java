package com.col.lab;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "user") 

public class Login implements Serializable {  
   private static final long serialVersionUID = 1L; 
   
   private int UserId; 
   private String FullName;
   private String UserName; 
   private String UserPwd;
   private String UserRole;
   private String IsActive;
   private String TemplatePath;
   public Login(){} 
    
   public Login(int userid, String fullname, String username, String userpwd, String userrole, String isactive, String templatepath){  
      this.UserId = userid;
      this.FullName = fullname;
      this.UserName = username; 
      this.UserPwd = userpwd;
      this.UserRole = userrole;
      this.IsActive = isactive;
      this.TemplatePath = templatepath;
   }  
   public int getUserId() { 
      return UserId; 
   }  
   @XmlElement 
   public void setUserId(int userid) { 
      this.UserId = userid; 
   } 
   public String getUserName() { 
      return UserName; 
   } 
   @XmlElement
   public void setUserName(String username) { 
      this.UserName = username; 
   } 
   public String getUserPwd() { 
      return UserPwd; 
   } 
   @XmlElement 
   public void setUserPwd(String userpwd) { 	   
      this.UserPwd = userpwd; 
   } 
   public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		this.FullName = fullName;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		this.UserRole = userRole;
	}
	public String getIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		this.IsActive = isActive;
	}
	public String getTemplatePath() {
		return TemplatePath;
	}
	public void setTemplatePath(String templatePath) {
		this.TemplatePath = templatePath;
	}
   @Override 
   public boolean equals(Object object){ 
      if(object == null){ 
         return false; 
      }else if(!(object instanceof Login)){ 
         return false; 
      }else { 
    	  Login user = (Login)object; 
         if(UserId == user.getUserId() 
            && UserName.equals(user.getUserName()) 
            && UserPwd.equals(user.getUserPwd())){ 
               return true; 
         }
      } 
      return false; 
   }
   
   @Override
   public String toString() {
    return "Login [userid=" + UserId + ", username=" + UserName
      + ", userpwd=" + UserPwd + ", userrole=" + UserRole + ", isactive=" + IsActive + ", templatepath=" + TemplatePath + "]";
   }
} 
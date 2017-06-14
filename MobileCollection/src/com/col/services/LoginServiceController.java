package com.col.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.col.data.LoginDao;
import com.col.lab.Login;

@RestController
public class LoginServiceController {
 
	LoginDao loginDao = new LoginDao();  
   
   @RequestMapping(value="/logins",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<Login> showAllLogins() {	 
	  List<Login> logins=loginDao.getAllLogins();
	  	return logins;	
	 }
   
   @RequestMapping(value="/logins/{username}/{userpwd}",method = RequestMethod.GET,headers="Accept=application/json")
	 public int checkLogin(@PathVariable String username,@PathVariable String userpwd)throws ParseException {	 
	 int chkUser = loginDao.validateLogin(username,userpwd);
	  	return chkUser;	
	 }
   
   @RequestMapping(value="/chklogin/{username}/{userpwd}",method = RequestMethod.GET,headers="Accept=application/json")
	 public Login checkUser(@PathVariable String username,@PathVariable String userpwd)throws ParseException {	 
	   Login login = loginDao.getLoginByName(username,userpwd);
	  	return login;	
	 }
}
package com.col.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.col.data.LabBillingDao;
import com.col.lab.LabBilling;


public class LabBillingServiceController {

	LabBillingDao billingDao = new LabBillingDao();  
	   
    @RequestMapping(value="/labbillings",method = RequestMethod.GET,headers="Accept=application/json")
	  public List<LabBilling> showLabBillings() {	 
	   List<LabBilling> billings = billingDao.getAllLabBilling();
	  	 return billings;	
    }	   
   
    @RequestMapping(value="/labbilling/{patientid}",method = RequestMethod.GET,headers="Accept=application/json")
	  public LabBilling checkUser(@PathVariable double patientid)throws ParseException {	 
	    LabBilling billing = billingDao.getAllLabBillingById(patientid);
	  	 return billing;	
    }
	
    
    
	
}

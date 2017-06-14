package com.col.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.col.conn.DataConnection;
import com.col.lab.LabBillingDetails;


public class LabBillingDetailsDao {

	private Connection conn;

	 public LabBillingDetailsDao() {
		 conn = DataConnection.getConnection();
	 }
	 
	 /*CREATE TABLE `patienttestdetails` (
		  `PatientTestDetailsId` bigint(11) NOT NULL AUTO_INCREMENT,
		  `PatientId` bigint(11) DEFAULT NULL,
		  `TestDetailsId` bigint(255) DEFAULT NULL,
		  `TestNM` varchar(140) DEFAULT NULL,
		  `SpecNo` varchar(32) DEFAULT NULL,
		  `SpecDt` varchar(40) DEFAULT NULL,
		  `TaxRate` decimal(18,0) DEFAULT NULL,
		  `TestRate` decimal(18,0) DEFAULT NULL,
		  `TestType` bigint(11) DEFAULT NULL,
		  `TestGrpNM` varchar(125) DEFAULT NULL,
		  `Status` varchar(1) DEFAULT NULL,
	 */
	 
	 public List<LabBillingDetails> getAllLabBillDetailsById(double patientid) {
		 List<LabBillingDetails> labBillingsDetails = new ArrayList<LabBillingDetails>();
		 try {			 
			 PreparedStatement preparedStatement = conn.
			 prepareStatement("select * from patienttestdetails where PatientId=? order by PatientTestDetailsId");
	    	 preparedStatement.setDouble(1, patientid);
	    	 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {
				 LabBillingDetails labBillingsDetail = new LabBillingDetails();
				 
				 labBillingsDetail.setObjId(rs.getDouble("PatientTestDetailsId"));
				 labBillingsDetail.setPatientId(rs.getDouble("PatientId"));
				 labBillingsDetail.setTestId(rs.getDouble("TestDetailsId"));
				 labBillingsDetail.setTestName(rs.getString("TestNM"));
				 labBillingsDetail.setSpecNo(rs.getString("SpecNo"));
				 labBillingsDetail.setSpecDt(rs.getString("SpecDt"));
				 labBillingsDetail.setTestRate(rs.getDouble("TestRate"));
				 labBillingsDetail.setGrpObjId(rs.getDouble("TestType"));
				 labBillingsDetail.setGrpName(rs.getString("TestGrpNM"));
				 
				 labBillingsDetails.add(labBillingsDetail);
			 }
		 } catch (SQLException e) {			 
			 e.printStackTrace();
		 }

		 return labBillingsDetails;
	}	
	 	 
	public void addPatientBillingDetails(LabBillingDetails labBillingsDetail) {
		 try {
			 PreparedStatement preparedStatementDel = conn
					 .prepareStatement("delete from patienttestdetails where PatientId=?");
			 preparedStatementDel.setDouble(1, labBillingsDetail.getObjId());
			 preparedStatementDel.executeUpdate();
			 
			 
			 PreparedStatement preparedStatement = conn
					 .prepareStatement("insert into patienttestdetails(PatientId,TestDetailsId,TestNM,SpecNo,SpecDt,TestRate,TestType,TestGrpNM) values (?, ?, ?, ?, ?, ?, ?, ?)");
			 System.out.println("Lab Billing Details : "+labBillingsDetail.getObjId());
			 preparedStatement.setDouble(1, labBillingsDetail.getPatientId());
			 preparedStatement.setDouble(2, labBillingsDetail.getTestId());   
			 preparedStatement.setString(3, labBillingsDetail.getTestName());
			 preparedStatement.setString(4, labBillingsDetail.getSpecNo());
			 preparedStatement.setString(5, labBillingsDetail.getSpecDt());
			 preparedStatement.setDouble(6, labBillingsDetail.getTestRate());
			 preparedStatement.setDouble(7, labBillingsDetail.getGrpObjId());
			 preparedStatement.setString(8, labBillingsDetail.getGrpName());
			 
			 preparedStatement.executeUpdate();
			 
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	}
	
}

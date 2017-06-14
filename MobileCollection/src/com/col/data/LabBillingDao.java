package com.col.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.col.conn.DataConnection;
import com.col.lab.LabBilling;

public class LabBillingDao {

	private Connection conn;

	 public LabBillingDao() {
		 conn = DataConnection.getConnection();
	 }
	
	 public List<LabBilling> getAllLabBilling() {
		 List<LabBilling> labBillings = new ArrayList<LabBilling>();
		 try {
			 Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery("select * from patient order by BillDate");
			 while (rs.next()) {
				 LabBilling labBilling = new LabBilling();
				 
				 labBilling.setPatientId(rs.getDouble("PatientId"));
				 labBilling.setPaMobile(rs.getString("paMobile"));
				 labBilling.setBillNo(rs.getString("BillNo"));
				 labBilling.setBillDate(rs.getString("BillDate"));
				 labBilling.setName(rs.getString("Name"));
				 labBilling.setAgeYrs(rs.getString("Age"));
				 labBilling.setAgeMonth(rs.getString("AgeMonth"));
				 labBilling.setAgeDays(rs.getString("AgeMonth"));
				 labBilling.setSex(rs.getString("Sex"));
				 labBilling.setAddress1(rs.getString("Address1"));
				 labBilling.setDoctorsId(rs.getDouble("DoctorsId"));
				 labBilling.setDoctorsNM(rs.getString("DoctorsNM"));
				 labBilling.setTestCost(rs.getDouble("TestCost"));
				 labBilling.setAdvance(rs.getDouble("Advance"));
				 labBilling.setAgentId(rs.getDouble("AgentId"));
				 labBilling.setAgentNM(rs.getString("AgentNM"));
				 
				 labBillings.add(labBilling);
			 }
		 } catch (SQLException e) {			 
			 e.printStackTrace();
		 }

		 return labBillings;
	}	
	 
	 
	 public LabBilling getAllLabBillingById(double patientid) {
		 LabBilling labBilling = new LabBilling();
		 try {
			 PreparedStatement preparedStatement = conn.
			 prepareStatement("select * from patient where PatientId=?");
	    	 preparedStatement.setDouble(1, patientid);
	    	 ResultSet rs = preparedStatement.executeQuery();
			 while (rs.next()) {				 
				 labBilling.setPatientId(rs.getDouble("PatientId"));
				 labBilling.setPaMobile(rs.getString("paMobile"));
				 labBilling.setBillNo(rs.getString("BillNo"));
				 labBilling.setBillDate(rs.getString("BillDate"));
				 labBilling.setName(rs.getString("Name"));
				 labBilling.setAgeYrs(rs.getString("Age"));
				 labBilling.setAgeMonth(rs.getString("AgeMonth"));
				 labBilling.setAgeDays(rs.getString("AgeMonth"));
				 labBilling.setSex(rs.getString("Sex"));
				 labBilling.setAddress1(rs.getString("Address1"));
				 labBilling.setDoctorsId(rs.getDouble("DoctorsId"));
				 labBilling.setDoctorsNM(rs.getString("DoctorsNM"));
				 labBilling.setTestCost(rs.getDouble("TestCost"));
				 labBilling.setAdvance(rs.getDouble("Advance"));
				 labBilling.setAgentId(rs.getDouble("AgentId"));
				 labBilling.setAgentNM(rs.getString("AgentNM"));
			 }
		 } catch (SQLException e) {			 
			 e.printStackTrace();
		 }

		 return labBilling;
	}	
	 
	 public void addTask(LabBilling labBilling) {
		 try {
			 PreparedStatement preparedStatement = conn
					 .prepareStatement("insert into patient(PatientId,paMobile,BillNo,BillDate,Name,Age,AgeMonth,Sex,Address1,DoctorsId,DoctorsNM,TestCost,Advance,AgentId,AgentNM) values (?, ?, ?,?,?,?,?,?, ?, ?,?,?,?,?,?)");
			 System.out.println("Lab Billing : "+labBilling.getPatientId());
			 preparedStatement.setDouble(1, labBilling.getPatientId());
			 preparedStatement.setString(2, labBilling.getPaMobile());   
			 preparedStatement.setString(3, labBilling.getBillNo());
			 //Date dt = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 String currentDateTime = sdf.format(labBilling.getBillDate());
			 preparedStatement.setString(4, currentDateTime);
			 preparedStatement.setString(5, labBilling.getName());
			 preparedStatement.setString(6, labBilling.getAgeYrs());
			 preparedStatement.setString(7, labBilling.getAgeMonth());
			 preparedStatement.setString(8, labBilling.getSex());
			 preparedStatement.setString(9, labBilling.getAddress1());
			 preparedStatement.setDouble(10, labBilling.getDoctorsId());
			 preparedStatement.setString(11, labBilling.getDoctorsNM());
			 preparedStatement.setDouble(12, labBilling.getTestCost());
			 preparedStatement.setDouble(13, labBilling.getAdvance());
			 preparedStatement.setDouble(14, labBilling.getAgentId());
			 preparedStatement.setString(15, labBilling.getAgentNM());
			 
			 preparedStatement.executeUpdate();
			 
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }
	 }
	 
	 public void updateTask(LabBilling labBilling) throws ParseException {
		 try {
			 PreparedStatement preparedStatement = conn
					 .prepareStatement("update patient set paMobile=?, BillDate=?, Name=?, Age=?, AgeMonth=?, Sex=?, Address1=?, DoctorsId=?, DoctorsNM=?, TestCost=?, Advance=?, AgentId=?, AgentNM=? " +
							 " where PatientId = ?");
			 preparedStatement.setString(1, labBilling.getPaMobile()); 
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 String currentDateTime = sdf.format(labBilling.getBillDate());
			 preparedStatement.setString(2, currentDateTime);
			 preparedStatement.setString(3, labBilling.getName());
			 preparedStatement.setString(4, labBilling.getAgeYrs());
			 preparedStatement.setString(5, labBilling.getAgeMonth());
			 preparedStatement.setString(6, labBilling.getSex());
			 preparedStatement.setString(7, labBilling.getAddress1());
			 preparedStatement.setDouble(8, labBilling.getDoctorsId());
			 preparedStatement.setString(9, labBilling.getDoctorsNM());
			 preparedStatement.setDouble(10, labBilling.getTestCost());
			 preparedStatement.setDouble(11, labBilling.getAdvance());
			 preparedStatement.setDouble(12, labBilling.getAgentId());
			 preparedStatement.setString(13, labBilling.getAgentNM());
			 
			 preparedStatement.setDouble(14, labBilling.getPatientId());
			 
			 preparedStatement.executeUpdate();
		 } catch (SQLException e) {
		  e.printStackTrace();
	  	 }
	 }
	 
}

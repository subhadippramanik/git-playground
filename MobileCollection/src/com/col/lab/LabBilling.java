package com.col.lab;

import javax.xml.bind.annotation.XmlElement;

public class LabBilling {

	private double PatientId; 
	private String PaMobile;
	private String BillNo; 
	private String BillDate;
	private String Name;
	private String AgeYrs;
	private String AgeMonth;
	private String AgeDays;
	private String Sex;
	private String Address1;
	private double DoctorsId;
	private String DoctorsNM;
	private double TestCost;
	private double LessAmnt;
	private double Advance;
	private double AgentId;
	private String AgentNM;
	
	public LabBilling(){} 
    
	public LabBilling(double patientId, String paMobile, String billNo,
			String billDate, String name, String ageYrs, String ageMonth,
			String ageDays, String sex, String address1, double doctorsId,
			String doctorsNM, double testCost, double lessAmnt, double advance,
			double agentId, String agentNM) {
		super();
		PatientId = patientId;
		PaMobile = paMobile;
		BillNo = billNo;
		BillDate = billDate;
		Name = name;
		AgeYrs = ageYrs;
		AgeMonth = ageMonth;
		AgeDays = ageDays;
		Sex = sex;
		Address1 = address1;
		DoctorsId = doctorsId;
		DoctorsNM = doctorsNM;
		TestCost = testCost;
		LessAmnt = lessAmnt;
		Advance = advance;
		AgentId = agentId;
		AgentNM = agentNM;
	}

	public double getPatientId() {
		return PatientId;
	}
	@XmlElement 
	public void setPatientId(double patientId) {
		PatientId = patientId;
	}	 
	public String getPaMobile() {
		return PaMobile;
	}
	@XmlElement 
	public void setPaMobile(String paMobile) {
		PaMobile = paMobile;
	}
	public String getBillNo() {
		return BillNo;
	}
	@XmlElement 
	public void setBillNo(String billNo) {
		BillNo = billNo;
	}
	public String getBillDate() {
		return BillDate;
	}
	@XmlElement 
	public void setBillDate(String billDate) {
		BillDate = billDate;
	}
	public String getName() {
		return Name;
	}
	@XmlElement 
	public void setName(String name) {
		Name = name;
	}
	public String getAgeYrs() {
		return AgeYrs;
	}
	@XmlElement 
	public void setAgeYrs(String ageYrs) {
		AgeYrs = ageYrs;
	}
	public String getAgeMonth() {
		return AgeMonth;
	}
	@XmlElement 
	public void setAgeMonth(String ageMonth) {
		AgeMonth = ageMonth;
	}
	public String getAgeDays() {
		return AgeDays;
	}
	@XmlElement 
	public void setAgeDays(String ageDays) {
		AgeDays = ageDays;
	}
	public String getSex() {
		return Sex;
	}
	@XmlElement 
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getAddress1() {
		return Address1;
	}
	@XmlElement 
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public double getDoctorsId() {
		return DoctorsId;
	}
	@XmlElement 
	public void setDoctorsId(double doctorsId) {
		DoctorsId = doctorsId;
	}
	public String getDoctorsNM() {
		return DoctorsNM;
	}
	@XmlElement 
	public void setDoctorsNM(String doctorsNM) {
		DoctorsNM = doctorsNM;
	}
	public double getTestCost() {
		return TestCost;
	}
	@XmlElement 
	public void setTestCost(double testCost) {
		TestCost = testCost;
	}
	public double getLessAmnt() {
		return LessAmnt;
	}
	@XmlElement 
	public void setLessAmnt(double lessAmnt) {
		LessAmnt = lessAmnt;
	}
	public double getAdvance() {
		return Advance;
	}
	@XmlElement 
	public void setAdvance(double advance) {
		Advance = advance;
	}
	public double getAgentId() {
		return AgentId;
	}
	@XmlElement 
	public void setAgentId(double agentId) {
		AgentId = agentId;
	}
	public String getAgentNM() {
		return AgentNM;
	}
	@XmlElement 
	public void setAgentNM(String agentNM) {
		AgentNM = agentNM;
	}

	@Override
    public String toString() {
     return "LabBilling [patientid=" + PatientId + ", pamobile=" + PaMobile
      + ", billno=" + BillNo + ", billdate=" + BillDate + ", name=" + Name
      + ", ageyrs=" + AgeYrs + ", agemonths=" + AgeMonth + ", agedays=" + AgeDays
      + ", sex=" + Sex + ", address1=" + Address1 + ", doctorsid=" + DoctorsId
      + ", doctorsnm=" + DoctorsNM + ", testcost=" + TestCost + ", advance=" +Advance
      + ", agentid=" + AgentId + ", agentnm=" + AgentNM + "]";
   }	
	
	
	
	
}

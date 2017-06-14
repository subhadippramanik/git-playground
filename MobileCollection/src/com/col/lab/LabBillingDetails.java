package com.col.lab;

import javax.xml.bind.annotation.XmlElement;

public class LabBillingDetails {	
	private double ObjId;
	private double PatientId; 
	private double TestId;
	private String TestName;
	private String SpecNo;
	private String SpecDt;
	private double TestRate;
	private double GrpObjId;
	private String GrpName;
	
	public LabBillingDetails(){} 
	
	public LabBillingDetails(double objId, double patientId, double testId,
			String testName, String specNo, String specDt, double testRate,
			double grpObjId, String grpName) {
		super();
		ObjId = objId;
		PatientId = patientId;
		TestId = testId;
		TestName = testName;
		SpecNo = specNo;
		SpecDt = specDt;
		TestRate = testRate;
		GrpObjId = grpObjId;
		GrpName = grpName;
	}
	
	public double getObjId() {
		return ObjId;
	}
	@XmlElement 
	public void setObjId(double objId) {
		ObjId = objId;
	}
	public double getPatientId() {
		return PatientId;
	}
	@XmlElement 
	public void setPatientId(double patientId) {
		PatientId = patientId;
	}
	public double getTestId() {
		return TestId;
	}
	@XmlElement 
	public void setTestId(double testId) {
		TestId = testId;
	}
	public String getTestName() {
		return TestName;
	}
	@XmlElement 
	public void setTestName(String testName) {
		TestName = testName;
	}
	public String getSpecNo() {
		return SpecNo;
	}
	@XmlElement 
	public void setSpecNo(String specNo) {
		SpecNo = specNo;
	}

	public String getSpecDt() {
		return SpecDt;
	}
	@XmlElement 
	public void setSpecDt(String specDt) {
		SpecDt = specDt;
	}

	public double getTestRate() {
		return TestRate;
	}
	@XmlElement 
	public void setTestRate(double testRate) {
		TestRate = testRate;
	}

	public double getGrpObjId() {
		return GrpObjId;
	}
	@XmlElement 
	public void setGrpObjId(double grpObjId) {
		GrpObjId = grpObjId;
	}
	public String getGrpName() {
		return GrpName;
	}
	@XmlElement 
	public void setGrpName(String grpName) {
		GrpName = grpName;
	}	
	
	@Override
	public String toString() {
		return "LabBillingDetails [ObjId=" + ObjId + ", PatientId=" + PatientId
				+ ", TestId=" + TestId + ", TestName=" + TestName + ", SpecNo="
				+ SpecNo + ", SpecDt=" + SpecDt + ", TestRate=" + TestRate
				+ ", GrpObjId=" + GrpObjId + ", GrpName=" + GrpName + "]";
	}

}

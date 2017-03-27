package com.hyulib.gate.domain;

public class UserEntryLog {
	private String College;
	private String Gate;
	private String EntryDate;
	private String EntryTime;
	private String UserId;
	private String UserName;
	private String UserPosition;
	private String Company;
	private String Dept;
	
	public String getUserPosition() {
		return UserPosition;
	}
	public void setUserPosition(String userPosition) {
		UserPosition = userPosition;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public String getGate() {
		return Gate;
	}
	public void setGate(String gate) {
		Gate = gate;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getEntryDate() {
		return EntryDate;
	}
	public void setEntryDate(String entryDate) {
		EntryDate = entryDate;
	}
	public String getEntryTime() {
		return EntryTime;
	}
	public void setEntryTime(String entryTime) {
		EntryTime = entryTime;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String companyName) {
		Company = companyName;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	
	
	

}

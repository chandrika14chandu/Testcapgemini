package com.capg.DTOLayer;
import java.util.List;
public class User {
	String UserId;
	List<DiagnosticCenter> centerList;
	public User(String userId, List<DiagnosticCenter> centerList) {
		super();
		UserId = userId;
		this.centerList = centerList;
	}
	public User() {
		super();
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}
	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}

	}





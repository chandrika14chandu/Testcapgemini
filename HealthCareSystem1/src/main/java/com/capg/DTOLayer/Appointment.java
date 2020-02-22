package com.capg.DTOLayer;
public class Appointment {
	User user; 
	int appointmentId;
	Test test;
	DateTime datetime;
	boolean approved;
	public Appointment(User user, int appointmentId, Test test, DateTime datetime, boolean approved) {
		super();
		this.user = user;
		this.appointmentId = appointmentId;
		this.test = test;
		this.datetime = datetime;
		this.approved = approved;
	}
	 public Appointment() {
			super();
		}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public DateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(DateTime datetime) {
		this.datetime = datetime;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
}
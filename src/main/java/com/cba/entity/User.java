package com.cba.entity;

public class User {
	
	private int userId;
	private String userName;
	private char gender;
	private int age;
	private Location location;
	private String phoneNumber;
	private String emailId;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int userId, String userName, char gender, int age, Location location, String phoneNumber,
			String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", age=" + age
				+ ", location=" + location + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
	}
	
	

}

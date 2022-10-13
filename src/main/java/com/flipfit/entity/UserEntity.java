package com.flipfit.entity;

public class UserEntity {
	private int userId;
	private String name;
	private String type;
	private String email;
	private String password;
	private boolean login;
	private boolean workoutBooked;
	private String bookedTime;
	
	
	public String getBookedTime() {
		return bookedTime;
	}


	public void setBookedTime(String bookedTime) {
		this.bookedTime = bookedTime;
	}


	public UserEntity(int userId, String name, String type, String email, String password, boolean login,
			boolean workoutBooked) {
		super();
		this.userId = userId;
		this.name = name;
		this.type = type;
		this.email = email;
		this.password = password;
		this.login = login;
		this.workoutBooked = workoutBooked;
	}


	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isLogin() {
		return login;
	}


	public void setLogin(boolean login) {
		this.login = login;
	}


	public boolean isWorkoutBooked() {
		return workoutBooked;
	}


	public void setWorkoutBooked(boolean workoutBooked) {
		this.workoutBooked = workoutBooked;
	}


	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", name=" + name + ", type=" + type + ", email=" + email + ", password="
				+ password + ", login=" + login + ", workoutBooked=" + workoutBooked + "]";
	}
	
	
	
	
	
	
}

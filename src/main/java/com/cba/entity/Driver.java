package com.cba.entity;

public class Driver {
	private int driverId;
	private String driverName;
	private char gender;
	private int age;
	private boolean active;
	private Location location;
	private int earnings;
	private VehicleDetails vehicleDetails;
	private String mobileNumber;
	private String emailId;
	
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Driver(int driverId, String driverName, char gender, int age, boolean active, Location location,
			int earnings, VehicleDetails vehicleDetails, String mobileNumber, String emailId) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.gender = gender;
		this.age = age;
		this.active = active;
		this.location = location;
		this.earnings = earnings;
		this.vehicleDetails = vehicleDetails;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
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


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public int getEarnings() {
		return earnings;
	}


	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}


	public VehicleDetails getVehicleDetails() {
		return vehicleDetails;
	}


	public void setVehicleDetails(VehicleDetails vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", gender=" + gender + ", age=" + age
				+ ", active=" + active + ", location=" + location + ", earnings=" + earnings + ", vehicleDetails="
				+ vehicleDetails + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + "]";
	}
	
	
	
	

}

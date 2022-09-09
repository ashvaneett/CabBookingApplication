package com.cba.entity;

public class Ride {
	
	private int driverId;
	private double driverApartFromSource;
	private VehicleDetails vehicleDetails;
	
	
	public Ride() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ride(int driverId, double driverApartFromSource, VehicleDetails vehicleDetails) {
		super();
		this.driverId = driverId;
		this.driverApartFromSource = driverApartFromSource;
		this.vehicleDetails = vehicleDetails;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public double getDriverApartFromSource() {
		return driverApartFromSource;
	}


	public void setDriverApartFromSource(double driverApartFromSource) {
		this.driverApartFromSource = driverApartFromSource;
	}


	public VehicleDetails getVehicleDetails() {
		return vehicleDetails;
	}


	public void setVehicleDetails(VehicleDetails vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}


	@Override
	public String toString() {
		return "Ride [driverId=" + driverId + ", driverApartFromSource=" + driverApartFromSource + ", vehicleDetails="
				+ vehicleDetails + "]";
	}
	
	
	

}

package com.cba.entity;


public class VehicleDetails {
	private String vehicleNumber;
	private String vehicleName;
	private VehicleType vehicleType;
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public VehicleDetails(String vehicleNumber, String vehicleName, VehicleType vehicleType) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
	}
	public VehicleDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VehicleDetails [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", vehicleType="
				+ vehicleType + "]";
	}
	

}

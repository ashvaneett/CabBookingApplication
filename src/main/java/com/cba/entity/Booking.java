package com.cba.entity;

public class Booking {
	private int bookingId;
	private int userId;
	private int driverId;
	private Location source;
	private Location destination;
	private int bill;
	private double journryDistance;
	
	


	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Booking(int bookingId, int userId, int driverId, Location source, Location destination, int bill) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.driverId = driverId;
		this.source = source;
		this.destination = destination;
		this.bill = bill;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public Location getSource() {
		return source;
	}


	public void setSource(Location source) {
		this.source = source;
	}


	public Location getDestination() {
		return destination;
	}


	public void setDestination(Location destination) {
		this.destination = destination;
	}


	public int getBill() {
		return bill;
	}


	public void setBill(int bill) {
		this.bill = bill;
	}
	public double getJournryDistance() {
		return journryDistance;
	}


	public void setJournryDistance(double journryDistance) {
		this.journryDistance = journryDistance;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", driverId=" + driverId + ", source="
				+ source + ", destination=" + destination + ", bill=" + bill + ", journryDistance=" + journryDistance
				+ "]";
	}


	
	
	

}

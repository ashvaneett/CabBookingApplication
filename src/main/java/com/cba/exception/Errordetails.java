package com.cba.exception;

import java.util.Date;

public class Errordetails {
	private Date timestamp;
	private String messageString;
	private String detailString;
	public Errordetails(Date timestamp, String messageString, String detailString) {
		super();
		this.timestamp = timestamp;
		this.messageString = messageString;
		this.detailString = detailString;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessageString() {
		return messageString;
	}
	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}
	public String getDetailString() {
		return detailString;
	}
	public void setDetailString(String detailString) {
		this.detailString = detailString;
	}
	
	

}

package com.example.pb.social_media.User.exception;

import java.time.LocalDateTime;

public class CustomErrorDetails {
	
	
	private LocalDateTime dateTime;
	private String msg;
	private String details;
	
	public CustomErrorDetails(LocalDateTime dateTime, String msg, String details) {
		super();
		this.dateTime = dateTime;
		this.msg = msg;
		this.details = details;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public String getMsg() {
		return msg;
	}
	public String getDetails() {
		return details;
	}
	
	
	
	

}

package com.paulorg.ui.model.response;

import java.util.Date;

public class ErrorMessage {
	
	private Date timestamp;
	
	private String message;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

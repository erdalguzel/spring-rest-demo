package dev.java8.springdemo.rest;

public class StudentErrorResponse {

	private String message;
	private String code;
	private String dateTime;

	public StudentErrorResponse() {
	}

	public StudentErrorResponse(String message, String code, String dateTime) {
		this.message = message;
		this.code = code;
		this.dateTime = dateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}

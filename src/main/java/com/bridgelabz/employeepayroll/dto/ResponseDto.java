package com.bridgelabz.employeepayroll.dto;
import lombok.Data;
@Data
public class ResponseDto {
	private String message;
	private Object name;
	public ResponseDto(String message,Object name) {
		this.message=message;
		this.name=name;
	}
	public ResponseDto(String message) {
		this.message=message;
	}
	/*
	 * public String getMessage() { return message; } public void setMessage(String
	 * message) { this.message = message; } public Object getName() { return name; }
	 * public void setName(Object name) { this.name = name; }
	 */
}

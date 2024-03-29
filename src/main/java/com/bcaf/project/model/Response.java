package com.bcaf.project.model;

import lombok.Getter;
import lombok.Setter;

public class Response<T> {
	private String service;
	private String message;
	private T data;
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}

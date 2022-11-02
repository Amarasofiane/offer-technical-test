package com.offer.test.api.exceptions;

import org.springframework.http.HttpStatus;

public class EntityResponseData {
	
	private HttpStatus status;
	private Object data;
	private int statusCode = 200;

	public EntityResponseData(Object data) {
		this.data = data;
	}

	public EntityResponseData(HttpStatus Status, int StatusCode) {
		this.status = Status;
		this.statusCode = StatusCode;

	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
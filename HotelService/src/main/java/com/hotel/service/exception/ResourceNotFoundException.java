package com.hotel.service.exception;

import org.hibernate.FetchNotFoundException;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String s) {
		super();
	}
	public ResourceNotFoundException() {
		super("Resource not FetchNotFoundException !!");
	}
	
}

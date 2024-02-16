package com.FlightManagementSystem.Customers.exceptions;

@SuppressWarnings("serial")
public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String string) {
		super(string);
	}

}

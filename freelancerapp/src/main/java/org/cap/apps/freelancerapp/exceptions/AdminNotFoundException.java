package org.cap.apps.freelancerapp.exceptions;

public class AdminNotFoundException extends RuntimeException{

	public AdminNotFoundException() {
		
	}
	
	public AdminNotFoundException(String msg) {
		super(msg);
	}
}

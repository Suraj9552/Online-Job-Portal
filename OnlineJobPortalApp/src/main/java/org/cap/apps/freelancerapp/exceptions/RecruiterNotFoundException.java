package org.cap.apps.freelancerapp.exceptions;

public class RecruiterNotFoundException extends RuntimeException{

	public RecruiterNotFoundException() {
		
	}
	
	public RecruiterNotFoundException(String msg) {
		super(msg);
	}
}

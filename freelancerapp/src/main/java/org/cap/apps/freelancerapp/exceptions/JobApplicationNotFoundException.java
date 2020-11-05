package org.cap.apps.freelancerapp.exceptions;

public class JobApplicationNotFoundException extends RuntimeException{

	public JobApplicationNotFoundException() {
		
	}
	
	public JobApplicationNotFoundException(String msg) {
		super(msg);
	}

}

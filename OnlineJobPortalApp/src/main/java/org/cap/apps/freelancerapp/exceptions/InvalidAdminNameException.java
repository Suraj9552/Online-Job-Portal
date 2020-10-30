package org.cap.apps.freelancerapp.exceptions;

public class InvalidAdminNameException extends RuntimeException{
	
	public InvalidAdminNameException() {		
	}
	
	public InvalidAdminNameException(String msg) {
		super(msg);
	}
}
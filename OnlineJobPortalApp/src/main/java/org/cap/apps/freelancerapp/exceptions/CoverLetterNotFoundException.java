package org.cap.apps.freelancerapp.exceptions;

public class CoverLetterNotFoundException extends RuntimeException{
	
	public CoverLetterNotFoundException() {		
	}
	
	public CoverLetterNotFoundException(String msg) {
		super(msg);
	}
}
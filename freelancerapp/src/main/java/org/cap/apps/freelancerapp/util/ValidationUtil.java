package org.cap.apps.freelancerapp.util;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.InvalidAdminNameException;
import org.cap.apps.freelancerapp.exceptions.InvalidArgumentException;
import org.cap.apps.freelancerapp.exceptions.InvalidIdException;
import org.cap.apps.freelancerapp.feedbackms.entities.Feedback;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;

public class ValidationUtil {

	public static void checkFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			throw new InvalidAdminNameException("firstname is not valid");
		}

	}

	public static void checkId(Long id) {
		if (id == null) {
			throw new InvalidIdException("Id is not valid");
		}
		if (id < 3060) {
			throw new InvalidIdException("Id is not valid");

		}
	}

	public static void checkArgumentNotNull(Freelancer freelancer) {
		if (freelancer == null) {
			throw new InvalidArgumentException("arg can't be null");
		}

	}

	public static void checkArgumentNotNull(Admin admin) {
		if (admin == null) {
			throw new InvalidArgumentException("arg can't be null");
		}

	}

	public static void checkLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			throw new InvalidAdminNameException("lastname is not valid");
		}

	}

	public static void checkArgumentNotNull(Feedback feedback) {
		if (feedback == null) {
			throw new InvalidArgumentException("arg can't be null");
		}
	}
}

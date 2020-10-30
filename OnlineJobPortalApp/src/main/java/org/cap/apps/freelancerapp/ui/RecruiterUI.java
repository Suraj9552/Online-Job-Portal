package org.cap.apps.freelancerapp.ui;

import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.recruiterms.service.IRecruiterService;
import org.cap.apps.freelancerapp.recruiterms.service.RecruiterServiceImpl;

public class RecruiterUI {
	private IRecruiterService recruiterservice = new RecruiterServiceImpl();

	public void recruiterUi() {
		add("Capgemini1", "Recruiter", "1234");

	}

	public Recruiter add(String firstName, String lastName, String Password) {
		Recruiter recruiter = new Recruiter(firstName, lastName, Password);
		recruiter = recruiterservice.save(recruiter);
		return recruiter;
	}

}

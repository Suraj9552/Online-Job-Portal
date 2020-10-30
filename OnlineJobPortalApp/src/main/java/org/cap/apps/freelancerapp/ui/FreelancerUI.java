package org.cap.apps.freelancerapp.ui;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.freelancerms.service.FreelancerServiceImpl;
import org.cap.apps.freelancerapp.freelancerms.service.IFreelancerService;

public class FreelancerUI {
	private IFreelancerService freelancerservice = new FreelancerServiceImpl();

	public void freelancerui() {
		add("Freelancer1", "Rohit", "1234");

	}

	public Freelancer add(String firstName, String lastName, String Password) {
		Freelancer freelancer = new Freelancer(firstName, lastName, Password);
		freelancer = freelancerservice.save(freelancer);
		return freelancer;
	}

}

package org.cap.apps.freelancerapp.jobapplicationms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.CoverLetterNotFoundException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class JobApplicationServiceImplTest {

	JobApplicationServiceImpl service;

	EntityManager entityManager;

	/* Testcase1 for coverletter not found for recruiter */

	@Test
	public void testCoverLetterNotFoundException() {
		Executable executable = new Executable() {
			@Override
			public void execute() throws Throwable {
				Skill skill = new Skill("Java", "FullStack");
				Recruiter postedBy = new Recruiter("Avichal", "Saxena", "root");
				LocalDate postedDate = LocalDate.now();
				Boolean active = true;
				Boolean value = active;
				Job job = new Job(skill, postedBy, postedDate, value);
				Freelancer freelancer = new Freelancer("Suraj", "Patil", "root");
				service.applyToJob(job, null, freelancer);
			}
		};
		Assertions.assertThrows(CoverLetterNotFoundException.class, executable);

	}
}

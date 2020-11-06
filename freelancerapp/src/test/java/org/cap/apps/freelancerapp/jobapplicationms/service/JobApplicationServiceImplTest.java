package org.cap.apps.freelancerapp.jobapplicationms.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(JobApplicationServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class JobApplicationServiceImplTest {


	@Autowired
	IJobApplicationService service;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void testApplytoJob() {
		Skill skill = new Skill();
		Recruiter postedBy=new Recruiter();
		LocalDate postedDate = LocalDate.parse("2019-11-01");
		Boolean active=true;
		Job job=new Job( skill,  postedBy,  postedDate, active);
		String coverLetter="I have good technical skill";
		String fName="Aniket";
		String lName="Aniket";
		String pass="Aniket123";
		Freelancer freelancer=new Freelancer(fName,lName,pass);
		JobApplication jobApplication=service.applyToJob(job, coverLetter, freelancer);
		TypedQuery<JobApplication>query=entityManager.createQuery("from JobApplication",JobApplication.class);
		List<JobApplication> jobApplicationList=query.getResultList();
		JobApplication storedJobApplication=jobApplicationList.get(0);
		Assertions.assertEquals(jobApplication.getId(),storedJobApplication.getId());
        Assertions.assertEquals(firstName,storedJobApplication.getFirstName());
        Assertions.assertEquals(lastName,storedJobApplication.getLastName());
        Assertions.assertEquals(age,storedJobApplication.getAge());
	}
}

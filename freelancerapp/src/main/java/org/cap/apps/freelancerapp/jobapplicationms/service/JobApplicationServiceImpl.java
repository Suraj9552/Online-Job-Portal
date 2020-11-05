package org.cap.apps.freelancerapp.jobapplicationms.service;

import java.time.LocalDateTime;


import javax.transaction.Transactional;

import org.cap.apps.freelancerapp.exceptions.JobApplicationNotFoundException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.dao.IJobApplicationDao;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class JobApplicationServiceImpl implements IJobApplicationService {
	
	@Autowired
	private IJobApplicationDao dao;

	@Override
	public JobApplication applyToJob(Job job, String coverLetter, Freelancer freelancer) {
	
		LocalDateTime appliedDate = LocalDateTime.now();
		JobApplication jobApplication = new JobApplication();
		jobApplication.setAppliedDate(appliedDate);
		jobApplication.setJob(job);
		jobApplication.setCoverLetter(coverLetter);
		jobApplication.setFreelancer(freelancer);
		jobApplication = dao.save(jobApplication);
		
		return jobApplication;
		
	}

	@Override
	public JobApplication updateJobApplication(Long id,Job job, String coverLetter, Freelancer freelancer) {
		
		boolean exists=id!=null && dao.existsById(id);
        if(!exists){
         throw new JobApplicationNotFoundException("Can't update, student not found for id="+id);
        }
		LocalDateTime appliedDate = LocalDateTime.now();
		JobApplication jobApplication = new JobApplication();
		jobApplication.setId(id);
		jobApplication.setAppliedDate(appliedDate);
		jobApplication.setJob(job);
		jobApplication.setCoverLetter(coverLetter);
		jobApplication.setFreelancer(freelancer);
		jobApplication = dao.save(jobApplication);
		return jobApplication;
	}
	@Override
	  public void  remove(Job job,Freelancer freelancer) {
		JobApplication jobApplication = dao.findByJobFreelancer(job,freelancer);
		dao.delete(jobApplication);
	}
	@Override
	public JobApplication findById(Long id) {
		JobApplication jobApplication = new JobApplication();
		return jobApplication;
	}

}
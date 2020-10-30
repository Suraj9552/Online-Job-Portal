package org.cap.apps.freelancerapp.jobapplicationms.service;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.CoverLetterNotFoundException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.dao.IJobApplicationDao;
import org.cap.apps.freelancerapp.jobapplicationms.dao.JobApplicationDaoImpl;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.util.JpaUtil;

public class JobApplicationServiceImpl implements IJobApplicationService {
	private IJobApplicationDao dao;

	private EntityManager entityManager;

	public JobApplicationServiceImpl() {
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
		dao = new JobApplicationDaoImpl(entityManager);

	}

	@Override
	public JobApplication applyToJob(Job job, String coverLetter, Freelancer freelancer) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		LocalDateTime applliedDate = LocalDateTime.now();
		JobApplication jobApplication = new JobApplication(job, applliedDate, coverLetter);
		jobApplication = dao.save(jobApplication);
		transaction.commit();
		JobApplication application = entityManager.find(JobApplication.class, coverLetter);
		if (application == null) {
			throw new CoverLetterNotFoundException("Cover letter not found=" + coverLetter);
		}
		return jobApplication;
	}

	@Override
	public JobApplication updateJobApplication(Job job, String coverLetter, Freelancer freelancer) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		LocalDateTime applliedDate = LocalDateTime.now();
		JobApplication jobApplication = new JobApplication(job, applliedDate, coverLetter, freelancer);
		jobApplication = dao.updateJobApplication(jobApplication);
		transaction.commit();
		return jobApplication;
	}

}
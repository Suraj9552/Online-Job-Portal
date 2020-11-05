package org.cap.apps.freelancerapp.jobapplicationms.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;

public class JobApplicationDaoImpl implements IJobApplicationDao {
	private EntityManager entityManager;

	public JobApplicationDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public JobApplication save(JobApplication application) {
		entityManager.persist(application);
		return application;
	}

	@Override
	public JobApplication updateJobApplication(JobApplication application) {
		entityManager.merge(application);
		return application;
	}

	@Override
	public void remove(JobApplication application) {
		String sql = "DELETE FROM UserDetails WHERE jobApplication= :application";
		Query query = entityManager.createQuery(sql);
		query.setParameter("application", application);
		query.executeUpdate();
	}

	@Override
	public JobApplication findById(Long id) {
		JobApplication jobApplication = entityManager.find(JobApplication.class, id);
		return jobApplication;
	}

}
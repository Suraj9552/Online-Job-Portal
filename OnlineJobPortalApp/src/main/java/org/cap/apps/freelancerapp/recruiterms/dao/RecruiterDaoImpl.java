package org.cap.apps.freelancerapp.recruiterms.dao;

import javax.persistence.EntityManager;

import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;

public class RecruiterDaoImpl implements IRecruiterDao {

	private EntityManager entityManager;

	public RecruiterDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Recruiter save(Recruiter recruiter) {
		entityManager.persist(recruiter);
		return recruiter;
	}

	@Override
	public Recruiter findById(Long id) {
		Recruiter recruiter = entityManager.find(Recruiter.class, id);
		return recruiter;
	}

	@Override
	public Recruiter update(Recruiter recruiter) {
		entityManager.persist(recruiter);
		return recruiter;
	}

}
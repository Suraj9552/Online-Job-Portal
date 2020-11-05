package org.cap.apps.freelancerapp.freelancerms.dao;

import javax.persistence.EntityManager;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;

public class FreelancerDaoImpl implements IFreelancerDao {

	private EntityManager entityManager;

	public FreelancerDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* Saving freelancer */
	@Override
	public Freelancer save(Freelancer freelancer) {
		entityManager.persist(freelancer);
		return freelancer;
	}

	/* Find the freelancer by id */
	@Override
	public Freelancer findById(Long id) {
		Freelancer freelancer = entityManager.find(Freelancer.class, id);
		return freelancer;
	}

	/* Updating freelancer */
	@Override
	public Freelancer update(Freelancer freelancer) {
		entityManager.persist(freelancer);
		return freelancer;
	}

}

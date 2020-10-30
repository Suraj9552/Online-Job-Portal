package org.cap.apps.freelancerapp.freelancerms.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.InvalidFreelancerException;
import org.cap.apps.freelancerapp.freelancerms.dao.FreelancerDaoImpl;
import org.cap.apps.freelancerapp.freelancerms.dao.IFreelancerDao;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.cap.apps.freelancerapp.util.ValidationUtil;

public class FreelancerServiceImpl implements IFreelancerService {

	private IFreelancerDao dao;

	private EntityManager entityManager;

	public FreelancerServiceImpl() {
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
		dao = new FreelancerDaoImpl(entityManager);
	}

	@Override
	public Freelancer save(Freelancer freelancer) {
		ValidationUtil.checkArgumentNotNull(freelancer);
		ValidationUtil.checkId(freelancer.getId());
		ValidationUtil.checkFirstName(freelancer.getFirstName());
		ValidationUtil.checkFirstName(freelancer.getLastName());
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		freelancer = dao.save(freelancer);
		transaction.commit();
		return freelancer;

	}

	@Override
	public Freelancer findById(Long id) {
		Freelancer freelancer = entityManager.find(Freelancer.class, id);
		if (freelancer == null) {
			throw new InvalidFreelancerException("Freelancer not found for id=" + id);
		}
		return freelancer;
	}

	@Override
	public Freelancer update(Freelancer freelancer) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		freelancer = dao.update(freelancer);
		transaction.commit();
		return freelancer;
	}

}
package org.cap.apps.freelancerapp.recruiterms.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.RecruiterNotFoundException;
import org.cap.apps.freelancerapp.recruiterms.dao.IRecruiterDao;
import org.cap.apps.freelancerapp.recruiterms.dao.RecruiterDaoImpl;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.util.JpaUtil;

public class RecruiterServiceImpl implements IRecruiterService {

	private IRecruiterDao dao;

	private EntityManager entityManager;

	public RecruiterServiceImpl() {
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
		dao = new RecruiterDaoImpl(entityManager);
	}

	@Override
	public Recruiter save(Recruiter recruiter) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		recruiter = dao.save(recruiter);
		transaction.commit();
		return recruiter;
	}

	@Override
	public Recruiter findById(Long id) {
		Recruiter recruiter = entityManager.find(Recruiter.class, id);
		if (recruiter == null) {
			throw new RecruiterNotFoundException("Recruiter not found for id=" + id);
		}

		return recruiter;

	}

	@Override
	public Recruiter update(Recruiter recruiter) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		recruiter = dao.update(recruiter);
		transaction.commit();
		return recruiter;
	}

}

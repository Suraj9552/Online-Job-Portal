package org.cap.apps.freelancerapp.adminms.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.cap.apps.freelancerapp.adminms.dao.AdminDaoImpl;
import org.cap.apps.freelancerapp.adminms.dao.IAdminDao;
import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.InvalidAdminNameException;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.cap.apps.freelancerapp.util.ValidationUtil;

public class AdminServiceImpl implements IAdminService {

	private IAdminDao dao;

	private EntityManager entityManager;

	public AdminServiceImpl() {
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
		dao = new AdminDaoImpl(entityManager);
	}

	@Override
	public Admin save(Admin admin) {
		ValidationUtil.checkArgumentNotNull(admin);
		ValidationUtil.checkId(admin.getId());
		ValidationUtil.checkFirstName(admin.getFirstName());
		ValidationUtil.checkLastName(admin.getLastName());
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		admin = dao.save(admin);
		transaction.commit();
		if (admin == null) {
			throw new InvalidAdminNameException("Admin name not found=" + admin);
		}
		return admin;
	}

	@Override
	public Admin findById(Long id) {
		Admin admin = entityManager.find(Admin.class, id);
		if (admin == null) {
			throw new AdminNotFoundException("Admin not found for id=" + id);
		}

		return admin;

	}

	@Override
	public Admin update(Admin admin) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		admin = dao.update(admin);
		transaction.commit();
		return admin;
	}

}

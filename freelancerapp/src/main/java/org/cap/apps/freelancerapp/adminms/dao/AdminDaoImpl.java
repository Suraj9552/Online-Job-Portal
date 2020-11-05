package org.cap.apps.freelancerapp.adminms.dao;

import javax.persistence.EntityManager;
import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;

public class AdminDaoImpl implements IAdminDao {

	private EntityManager entityManager;

	public AdminDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* Saving the Admin Data */

	@Override
	public Admin save(Admin admin) {
		entityManager.persist(admin);
		return admin;
	}

	/* Finding the Admin data by Id */

	@Override
	public Admin findById(Long id) {
		Admin admin = entityManager.find(Admin.class, id);
		if (admin == null) {
			throw new AdminNotFoundException("employee not found for id=" + id);
		}
		return admin;
	}

	/* Updating the Admin Data */

	@Override
	public Admin update(Admin admin) {
		entityManager.persist(admin);
		return admin;
	}

}

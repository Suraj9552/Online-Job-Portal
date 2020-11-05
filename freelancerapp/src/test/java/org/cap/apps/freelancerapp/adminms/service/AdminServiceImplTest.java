package org.cap.apps.freelancerapp.adminms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.InvalidAdminNameException;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class AdminServiceImplTest {

	AdminServiceImpl service;

	EntityManager entityManager;

	@BeforeEach
	public void setup() {
		service = new AdminServiceImpl();
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
	}

	/* Testcase for saving the data of admin */
	@Test
	public void testSave_1() {
		String firstName = "avichal";
		String lastName = "saxena";
		String pass = "root";
		Admin admin = new Admin(firstName, lastName, pass);
		admin = service.save(admin);
		TypedQuery<Admin> query = entityManager.createQuery("from Admin", Admin.class);
		List<Admin> list = query.getResultList();
		Assertions.assertEquals(2, list.size());
		Admin stored = list.get(0);
		Assertions.assertEquals(firstName, stored.getFirstName());
		Assertions.assertEquals(lastName, stored.getLastName());
		Assertions.assertEquals(pass, stored.getPassword());
	}

	/* Testcase to find the data by id */
	@Test
	public void testFindById_1() {
		String firstName = "avichal";
		String lastName = "saxena";
		String pass = "root";
		Admin admin = new Admin(firstName, lastName, pass);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(admin);
		transaction.commit();
		Long id = admin.getId();
		Admin actual = service.findById(id);
		Assertions.assertEquals(id, actual.getId());
		Assertions.assertEquals(firstName, actual.getFirstName());
		Assertions.assertEquals(lastName, actual.getLastName());

	}

	/* Testcase to check that admin data can be fetched by id */
	@Test
	public void testFindById_2() {
		Executable executable = new Executable() {
			@Override
			public void execute() throws Throwable {
				service.findById(11L);
			}
		};
		Assertions.assertThrows(AdminNotFoundException.class, executable);

	}

	/* Testcase2 to check the data whether it is saved or not */
	@Test
	public void testSave_2() {

		Executable executable = new Executable() {
			@Override
			public void execute() throws Throwable {
				Admin admin = new Admin(" ", "Saxena", "root");
				admin = service.save(admin);

			}
		};

		Assertions.assertThrows(InvalidAdminNameException.class, executable);

	}

}

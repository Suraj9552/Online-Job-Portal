package org.cap.apps.freelancerapp.freelancerms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.adminms.service.AdminServiceImpl;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.InvalidFreelancerException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class FreelancerServiceImplTest {

	FreelancerServiceImpl service;

	EntityManager entityManager;

	@BeforeEach
	public void setup() {
		service = new FreelancerServiceImpl();
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
	}

	/* Testcase1 for saving the data */
	@Test
	public void testSave_1() {
		String firstName = "Suraj";
		String lastName = "Patil";
		String pass = "root";
		Freelancer freelancer = new Freelancer(firstName, lastName, pass);
		freelancer = service.save(freelancer);
		TypedQuery<Freelancer> query = entityManager.createQuery("from Freelancer", Freelancer.class);
		List<Freelancer> list = query.getResultList();
		Assertions.assertEquals(1, list.size());
		Freelancer stored = list.get(0);
		Assertions.assertEquals(firstName, stored.getFirstName());
		Assertions.assertEquals(lastName, stored.getLastName());
		Assertions.assertEquals(pass, stored.getPassword());
	}

	/* Testcase2 to check the data by id */
	@Test
	public void testFindById_1() {
		Executable executable = new Executable() {
			@Override
			public void execute() throws Throwable {
				service.findById(20L);
			}
		};
		Assertions.assertThrows(InvalidFreelancerException.class, executable);

	}
}

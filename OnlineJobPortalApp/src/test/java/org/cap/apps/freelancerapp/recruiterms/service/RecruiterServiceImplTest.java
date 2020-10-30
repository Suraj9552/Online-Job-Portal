package org.cap.apps.freelancerapp.recruiterms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.adminms.service.AdminServiceImpl;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.RecruiterNotFoundException;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class RecruiterServiceImplTest {
	RecruiterServiceImpl service;

	EntityManager entityManager;

	@BeforeEach
	public void setup() {
		service = new RecruiterServiceImpl();
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
	}

	/* testcase for saving the data */

	@Test
	public void testSave_1() {
		String firstName = "shreya";
		String lastName = "sharma";
		String pass = "root";
		Recruiter recruiter = new Recruiter(firstName, lastName, pass);
		recruiter = service.save(recruiter);
		TypedQuery<Recruiter> query = entityManager.createQuery("from Recruiter", Recruiter.class);
		List<Recruiter> list = query.getResultList();
		Assertions.assertEquals(1, list.size());
		Recruiter stored = list.get(0);
		Assertions.assertEquals(firstName, stored.getFirstName());
		Assertions.assertEquals(lastName, stored.getLastName());
		Assertions.assertEquals(pass, stored.getPassword());
	}

	/* Testcase for finding data by id */
	@Test
	public void testFindById_1() {
		Executable executable = new Executable() {
			@Override
			public void execute() throws Throwable {
				service.findById(101L);
			}
		};
		Assertions.assertThrows(RecruiterNotFoundException.class, executable);

	}

}

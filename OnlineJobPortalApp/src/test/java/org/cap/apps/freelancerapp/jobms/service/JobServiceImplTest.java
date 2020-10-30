/**
 * 
 */
package org.cap.apps.freelancerapp.jobms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JobServiceImplTest {

	JobServiceImpl service;

	EntityManager entityManager;

	@BeforeEach
	public void setup() {
		service = new JobServiceImpl();
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
	}

	@AfterEach
	public void clear() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("delete from Job");
		query.executeUpdate();
		transaction.commit();
	}

	/* Testcase for saving the data */

	@Test
	public void testSave_1() {
		Skill skill = new Skill("Avichal", "Java,jpa");
		Recruiter postedBy = new Recruiter("Shreya", "kal", "root");
		LocalDate postedDate = LocalDate.now();
		Boolean active = true;
		Job job = new Job(skill, postedBy, postedDate, active);
		job = service.updateJob(job);
		TypedQuery<Job> query = entityManager.createQuery("from Job", Job.class);
		List<Job> list = query.getResultList();
		Assertions.assertEquals(1, list.size());
		Job stored = list.get(0);
		Assertions.assertEquals(skill, stored.getSkill());
		Assertions.assertEquals(postedBy, stored.getPostedBy());
		Assertions.assertEquals(postedDate, stored.getPostedDate());
		Assertions.assertEquals(active, stored.getActive());
	}

}

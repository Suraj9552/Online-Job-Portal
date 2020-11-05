package org.cap.apps.freelancerapp.skillms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkillServiceImplTest {

	SkillServiceImpl service;

	EntityManager entityManager;

	@BeforeEach
	public void setup() {
		service = new SkillServiceImpl();
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
	}

	@AfterEach
	public void clear() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("delete from Skill");
		query.executeUpdate();
		transaction.commit();
	}

	/* Testcase for saving the data */

	@Test
	public void testSave_1() {
		String name = "Shreya";
		String skills = "Java,Jpa,Mysql";
		Skill skill = new Skill(name, skills);
		skill = service.save(skill);
		TypedQuery<Skill> query = entityManager.createQuery("from Skill", Skill.class);
		List<Skill> list = query.getResultList();
		Assertions.assertEquals(1, list.size());
		Skill stored = list.get(0);
		Assertions.assertEquals(name, stored.getName());
		Assertions.assertEquals(skills, stored.getDescription());

	}

	/* Testcase for finding the data by id */

	@Test
	public void testFindById_1() {
		String name = "Shreya";
		String skills = "Java,Jpa,Mysql";
		Skill skill = new Skill(name, skills);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(skill);
		transaction.commit();
		Long id = skill.getId();
		Skill actual = service.findById(id);
		Assertions.assertEquals(id, actual.getId());
		Assertions.assertEquals(name, actual.getName());
		Assertions.assertEquals(skills, actual.getDescription());

	}

}

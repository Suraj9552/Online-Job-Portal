package org.cap.apps.freelancerapp.skillms.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.cap.apps.freelancerapp.skillms.dao.SkillDaoImpl;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.util.JpaUtil;

public class SkillServiceImpl implements ISkillService {

	private SkillDaoImpl skilldao;
	private EntityManager entityManager;

	public SkillServiceImpl() {
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
		skilldao = new SkillDaoImpl(entityManager);
	}

	@Override
	public Skill save(Skill skill) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		skill = skilldao.save(skill);
		transaction.commit();
		return skill;
	}

	@Override
	public Skill update(Skill skill) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		skill = skilldao.update(skill);
		transaction.commit();
		return skill;
	}

	@Override
	public Skill remove(Skill skill) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		skill = skilldao.remove(skill);
		transaction.commit();
		return skill;
	}

	@Override
	public Skill findById(Long id) {
		Skill skill = skilldao.findById(id);
		return skill;
	}

	@Override
	public Skill findByName(String name) {
		Skill skill = skilldao.findByName(name);
		return skill;
	}

}

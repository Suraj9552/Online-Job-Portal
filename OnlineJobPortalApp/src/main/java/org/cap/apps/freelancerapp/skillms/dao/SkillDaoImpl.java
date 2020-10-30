package org.cap.apps.freelancerapp.skillms.dao;

import javax.persistence.EntityManager;

import org.cap.apps.freelancerapp.skillms.entities.Skill;

public class SkillDaoImpl implements ISkillDao {

	private EntityManager entityManager;

	public SkillDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Skill save(Skill skill) {
		entityManager.persist(skill);
		return skill;
	}

	@Override
	public Skill update(Skill skill) {
		entityManager.persist(skill);
		return skill;
	}

	@Override
	public Skill remove(Skill skill) {
		entityManager.persist(skill);
		return skill;
	}

	@Override
	public Skill findById(Long id) {
		Skill skill = entityManager.find(Skill.class, id);
		return skill;
	}

	@Override
	public Skill findByName(String name) {
		Skill skill = entityManager.find(Skill.class, name);
		return skill;
	}

}

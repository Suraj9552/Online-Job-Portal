package org.cap.apps.freelancerapp.skillexperiencems.dao;

import javax.persistence.EntityManager;

import org.cap.apps.freelancerapp.skillexperiencems.entities.SkillExperience;

public class SkillExperienceDaoImpl implements ISkillExperienceDao {

	private EntityManager entityManager;

	public SkillExperienceDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public SkillExperience save(SkillExperience experience) {
		entityManager.persist(experience);
		return experience;
	}

	@Override
	public SkillExperience update(SkillExperience experience) {
		entityManager.persist(experience);
		return experience;
	}

	@Override
	public void remove(SkillExperience experience) {
		entityManager.persist(experience);

	}

	@Override
	public SkillExperience findById(Long id) {
		SkillExperience experience = entityManager.find(SkillExperience.class, id);
		return experience;
	}

}

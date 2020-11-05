package org.cap.apps.freelancerapp.jobms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

public class JobDaoImpl implements IJobDao {
	
	private EntityManager entityManager;
	public JobDaoImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	
	@Override
	public Job save(Job job) {
		entityManager.persist(job);
		return job;
	}

	@Override
	public Job findById(Long id) {
		Job job = entityManager.find(Job.class,id);
		return job;
	}

	@Override
	public Job update(Job job) {
		entityManager.persist(job);
		return job;
	}

	@Override
	public List<Job> findJobsBySkill(Skill skill) {
		String ql = "from Job where skill = :skill" ;
		TypedQuery<Job> query = entityManager.createQuery(ql, Job.class);
		query.setParameter("skill", skill);
		List<Job> list = query.getResultList();
		return list;
	}

}
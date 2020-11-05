package org.cap.apps.freelancerapp.jobms.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.cap.apps.freelancerapp.jobms.dao.IJobDao;
import org.cap.apps.freelancerapp.jobms.dao.JobDaoImpl;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.util.JpaUtil;

public class JobServiceImpl implements IJobService {
	private IJobDao dao;
	private EntityManager entityManager;

	public JobServiceImpl() {
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
		dao = new JobDaoImpl(entityManager);
	}

	@Override
	public Job postJob(Skill skill, Recruiter recruiter) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		LocalDate postDate = LocalDate.now();
		Boolean active = true;
		Boolean value = active;
		Job job = new Job(skill, recruiter, postDate, value);
		job = dao.save(job);
		transaction.commit();
		return job;
	}

	@Override
	public Job findById(Long id) {
		Job job = dao.findById(id);
		return job;
	}

	@Override
	public List<Job> findJobBySkill(Skill skill) {
		List<Job> list = dao.findJobsBySkill(skill);
		return list;

	}

	@Override
	public Job updateJob(Job job) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		job = dao.update(job);
		transaction.commit();
		return job;
	}

	@Override
	public void close(Job job) {
		job.setActive(false);
		updateJob(job);

	}

}
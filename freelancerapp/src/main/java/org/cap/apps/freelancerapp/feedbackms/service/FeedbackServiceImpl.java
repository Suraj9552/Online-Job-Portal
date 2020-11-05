package org.cap.apps.freelancerapp.feedbackms.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import org.cap.apps.freelancerapp.feedbackms.dao.FeedbackDaoImpl;
import org.cap.apps.freelancerapp.feedbackms.dao.IFeedbackDao;
import org.cap.apps.freelancerapp.feedbackms.entities.Feedback;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.cap.apps.freelancerapp.util.ValidationUtil;

public class FeedbackServiceImpl implements IFeedbackService {

	private IFeedbackDao dao;
	private EntityManager entityManager;

	public FeedbackServiceImpl() {
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
		dao = new FeedbackDaoImpl(entityManager);
	}

	/* Feedback created */
	@Override
	public Feedback createFeedback(Recruiter recruiter, Freelancer freelancer, int rating, String review) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Feedback feedback = new Feedback(recruiter, freelancer, rating, review);
		ValidationUtil.checkArgumentNotNull(feedback);
		feedback = dao.save(feedback);
		transaction.commit();
		return feedback;
	}

	/* Average rating of freelancer */
	@Override
	public int averageRating(Freelancer freelancer) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		int i = 0;
		transaction.commit();
		return i;
	}

	@Override
	public List<Feedback> findFeedbacksByFreelancer(Freelancer freelancer) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Feedback> list = dao.findFeedbacksByFreelancer(freelancer);
		return list;
	}

}
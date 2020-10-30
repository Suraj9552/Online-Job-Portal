package org.cap.apps.freelancerapp.feedbackms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import org.cap.apps.freelancerapp.feedbackms.entities.Feedback;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;

public class FeedbackDaoImpl implements IFeedbackDao {

	private EntityManager entityManager;

	public FeedbackDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* Saving feedback */

	@Override
	public Feedback save(Feedback feedback) {
		entityManager.persist(feedback);
		return feedback;
	}

	/* Updating feedback */

	@Override
	public Feedback update(Feedback feedback) {
		entityManager.persist(feedback);
		return feedback;
	}

	/* Find the feedback by id */

	@Override
	public Feedback findFeedbackById(Long id) {
		Feedback feedback = entityManager.find(Feedback.class, id);
		return feedback;
	}

	/* Find the list of freelancer by id */

	@Override
	public List<Feedback> findFeedbacksByFreelancer(Freelancer freelancer) {
		entityManager.find(Feedback.class, freelancer);
		List<Feedback> feedbacklist = new ArrayList<>();
		return feedbacklist;
	}

}
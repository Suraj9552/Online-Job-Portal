package org.cap.apps.freelancerapp.feedbackms.dao;

import org.cap.apps.freelancerapp.feedbackms.entities.Feedback;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;


import java.util.List;

public interface IFeedbackDao {

    Feedback save(Feedback feedback);

    Feedback update(Feedback feedback);

    Feedback findFeedbackById(Long id);

    List<Feedback> findFeedbacksByFreelancer(Freelancer freelancer);

	

}

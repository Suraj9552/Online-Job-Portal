package org.cap.apps.freelancerapp.feedbackms.service;

import org.cap.apps.freelancerapp.feedbackms.entities.Feedback;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;

import java.util.List;

public interface IFeedbackService {

   Feedback createFeedback(Recruiter recruiter, Freelancer freelancer, int rating, String review);

   int averageRating(Freelancer freelancer) ;

   List<Feedback>findFeedbacksByFreelancer(Freelancer freelancer);

}

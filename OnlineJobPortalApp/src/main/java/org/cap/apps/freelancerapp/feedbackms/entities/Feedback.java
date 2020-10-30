package org.cap.apps.freelancerapp.feedbackms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;

@Entity
@Table(name = "feedback")
public class Feedback {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private Integer rating;
	private String comment;

	public Feedback(Integer rating, String comment) {

		this.rating = rating;
		this.comment = comment;
	}

	public Feedback(Recruiter recruiter, Freelancer freelancer, int rating, String review) {

	}

	/* Getter and Setter */

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
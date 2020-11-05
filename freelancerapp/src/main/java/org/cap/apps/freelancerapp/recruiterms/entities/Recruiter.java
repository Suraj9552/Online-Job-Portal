package org.cap.apps.freelancerapp.recruiterms.entities;

import org.cap.apps.freelancerapp.feedbackms.entities.Feedback;
import org.cap.apps.freelancerapp.jobms.entities.Job;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.Objects;

@Table(name = "recruiter")
@Entity
public class Recruiter {
	@GeneratedValue
	@Id
	private Long id;

	private String firstName, lastName, password;

	@OneToMany(mappedBy = "postedBy")
	private List<Job> postedJobs;
	@OneToMany
	private List<Feedback> feedbacks;

	public Recruiter() {

	}

	public Recruiter(String firstName, String lastName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Job> getPostedJobs() {
		return postedJobs;
	}

	public void setPostedJobs(List<Job> postedJobs) {
		this.postedJobs = postedJobs;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Recruiter recruiter = (Recruiter) o;
		return Objects.equals(id, recruiter.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

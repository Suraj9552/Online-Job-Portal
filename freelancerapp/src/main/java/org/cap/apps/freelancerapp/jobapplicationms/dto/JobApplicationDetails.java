package org.cap.apps.freelancerapp.jobapplicationms.dto;

import java.time.LocalDateTime;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobms.entities.Job;

public class JobApplicationDetails {

	private Long id;

	private Job job;

	private LocalDateTime appliedDate;

	private String coverLetter;

	private Freelancer freelancer;

	public JobApplicationDetails() {
		super();

	}

	public JobApplicationDetails(Long id, Job job, LocalDateTime appliedDate, String coverLetter,
			Freelancer freelancer) {
		this.id = id;
		this.job = job;
		this.appliedDate = appliedDate;
		this.coverLetter = coverLetter;
		this.freelancer = freelancer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDateTime appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

}

package org.cap.apps.freelancerapp.jobms.entities;

import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "job")
public class Job {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@ManyToOne
	private Skill skill;
	@ManyToOne
	private Recruiter postedBy;
	private LocalDate postedDate;
	// private Freelancer awardedTo;
	private Boolean active;
	@OneToMany(mappedBy = "job")
	private List<JobApplication> jobApplications;

	public Job() {

	}

	public Job(Skill skill, Recruiter postedBy, LocalDate postedDate, Boolean active) {

		this.skill = skill;
		this.postedBy = postedBy;
		this.postedDate = postedDate;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Recruiter getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Recruiter postedBy) {
		this.postedBy = postedBy;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Job job = (Job) o;
		return Objects.equals(id, job.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

package org.cap.apps.freelancerapp.jobapplicationms.controller;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.dto.JobApplicationDetails;
import org.cap.apps.freelancerapp.jobapplicationms.dto.JobApplicationRequest;
import org.cap.apps.freelancerapp.jobapplicationms.dto.UpdateJobApplication;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.jobapplicationms.service.IJobApplicationService;
import org.cap.apps.freelancerapp.jobapplicationms.util.JobApplicationUtil;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/jobapplication")
@RestController
public class jobApplicationController {

	@Autowired
	private IJobApplicationService service;

	@Autowired
	private JobApplicationUtil jobApplicationUtil;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/apply")
	public JobApplicationDetails apply(@RequestBody JobApplicationRequest requestData) {

		JobApplication jopbApplication = service.applyToJob(requestData.getJob(), requestData.getCoverLetter(),
				requestData.getFreelancer());
		JobApplicationDetails details = jobApplicationUtil.toDetails(jopbApplication);
		return details;
	}

	@PutMapping("/update")
	public JobApplicationDetails update(@RequestBody UpdateJobApplication requestData) {

		JobApplication jopApplication = service.updateJobApplication(requestData.getId(), requestData.getJob(),
				requestData.getCoverLetter(), requestData.getFreelancer());
		JobApplicationDetails details = jobApplicationUtil.toDetails(jopApplication);
		return details;
	}

	@DeleteMapping("/remove/{job,freelancer}")
	public String removeJobApplication(@PathVariable("job") Job job,
			@PathVariable("freelancer") Freelancer freelancer) {
		service.remove(job, freelancer);
		String response = "Job Application removed with Job Name-" + job + "Freelancer name-" + freelancer;
		return response;
	}

	@GetMapping("/by/id/{id}")
	public JobApplicationDetails fetchJobApplication(@PathVariable("id") Long id) {
		JobApplication jobApplication = service.findById(id);
		JobApplicationDetails details = jobApplicationUtil.toDetails(jobApplication);
		return details;
	}

}

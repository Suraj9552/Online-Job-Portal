package org.cap.apps.freelancerapp.jobapplicationms.util;

import org.cap.apps.freelancerapp.jobapplicationms.dto.JobApplicationDetails;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;

public class JobApplicationUtil {
	public JobApplicationDetails toDetails(JobApplication jobApplication) {
		JobApplicationDetails details = new JobApplicationDetails(jobApplication.getId(), jobApplication.getJob(),
				jobApplication.getAppliedDate(), jobApplication.getCoverLetter(), jobApplication.getFreelancer());
		return details;

	}
}
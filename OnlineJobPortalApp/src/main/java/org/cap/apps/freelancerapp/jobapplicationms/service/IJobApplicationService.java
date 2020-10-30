package org.cap.apps.freelancerapp.jobapplicationms.service;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.jobms.entities.Job;

public interface IJobApplicationService {

    JobApplication applyToJob(Job job, String coverLetter, Freelancer freelancer);

    JobApplication updateJobApplication(Job job, String coverLetter, Freelancer freelancer);

    
}

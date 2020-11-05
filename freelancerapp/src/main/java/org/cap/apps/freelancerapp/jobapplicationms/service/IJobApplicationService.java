package org.cap.apps.freelancerapp.jobapplicationms.service;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.jobms.entities.Job;

public interface IJobApplicationService {

    JobApplication applyToJob(Job job, String coverLetter, Freelancer freelancer);

    JobApplication updateJobApplication(Long id,Job job, String coverLetter, Freelancer freelancer);

    void  remove(Job job,Freelancer freelancer);
    
    JobApplication findById(Long id);
}

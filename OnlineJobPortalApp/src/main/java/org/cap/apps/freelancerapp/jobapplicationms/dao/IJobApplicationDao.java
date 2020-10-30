package org.cap.apps.freelancerapp.jobapplicationms.dao;

import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;

public interface IJobApplicationDao {
    JobApplication save(JobApplication application);

    JobApplication updateJobApplication(JobApplication application);

    void remove(JobApplication application);

    JobApplication findById(Long id);
}

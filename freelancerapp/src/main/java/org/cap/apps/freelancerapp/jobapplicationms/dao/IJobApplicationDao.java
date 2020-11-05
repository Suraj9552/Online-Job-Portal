package org.cap.apps.freelancerapp.jobapplicationms.dao;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IJobApplicationDao extends JpaRepository<JobApplication, Long>{
	
    @Query("from Student where job=:job and freelancer=:freelancer")
    JobApplication findByJobFreelancer(@Param("job") Job job,@Param("freelancer") Freelancer freelancer);
    
    
}

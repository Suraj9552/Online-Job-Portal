package org.cap.apps.freelancerapp.recruiterms.dao;

import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;

public interface IRecruiterDao {

    Recruiter save(Recruiter recruiter);

    Recruiter findById(Long id);

    Recruiter update(Recruiter recruiter);
}

package org.cap.apps.freelancerapp.recruiterms.service;

import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;

public interface IRecruiterService {
    Recruiter save(Recruiter recruiter);

    Recruiter findById(Long id);

    Recruiter update(Recruiter recruiter);
}

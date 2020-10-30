package org.cap.apps.freelancerapp.freelancerms.service;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;

public interface IFreelancerService {
    Freelancer save(Freelancer freelancer);

    Freelancer findById(Long id);

    Freelancer update(Freelancer freelancer);
}

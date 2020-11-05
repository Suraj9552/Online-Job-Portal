package org.cap.apps.freelancerapp.freelancerms.dao;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;

public interface IFreelancerDao {
    Freelancer save(Freelancer freelancer);

    Freelancer findById(Long id);

    Freelancer update(Freelancer freelancer);
}

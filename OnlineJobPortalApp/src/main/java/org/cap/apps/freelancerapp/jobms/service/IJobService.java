package org.cap.apps.freelancerapp.jobms.service;

import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

import java.util.List;

public interface IJobService {
    Job postJob(Skill skill, Recruiter recruiter);

    Job findById(Long id);

    List<Job> findJobBySkill(Skill skill);

    Job updateJob(Job job);

    void close(Job job);
}

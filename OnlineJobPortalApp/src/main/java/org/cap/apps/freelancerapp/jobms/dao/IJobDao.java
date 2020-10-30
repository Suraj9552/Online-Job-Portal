package org.cap.apps.freelancerapp.jobms.dao;

import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

import java.util.List;

public interface IJobDao {

    Job save(Job job);

    Job findById(Long id);

    Job update(Job job);

    List<Job>findJobsBySkill(Skill skill);
}

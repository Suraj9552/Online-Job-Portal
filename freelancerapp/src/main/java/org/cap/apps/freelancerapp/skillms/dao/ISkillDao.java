package org.cap.apps.freelancerapp.skillms.dao;

import org.cap.apps.freelancerapp.skillms.entities.Skill;

public interface ISkillDao {

    Skill save(Skill skill);

    Skill update(Skill skill);

    Skill remove(Skill skill);

    Skill findById(Long id);

    Skill findByName(String name);
}

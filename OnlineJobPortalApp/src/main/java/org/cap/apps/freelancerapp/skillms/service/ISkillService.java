package org.cap.apps.freelancerapp.skillms.service;

import org.cap.apps.freelancerapp.skillms.entities.Skill;

public interface ISkillService {

   Skill save(Skill skill);

   Skill update(Skill skill);

   Skill remove(Skill skill);

   Skill findById(Long id);

   Skill findByName(String name);

}

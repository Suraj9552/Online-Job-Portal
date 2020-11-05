package org.cap.apps.freelancerapp.ui;

import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.skillms.service.ISkillService;
import org.cap.apps.freelancerapp.skillms.service.SkillServiceImpl;

public class SkillUI {
	private ISkillService skillService = new SkillServiceImpl();

	public void SkillUi() {
		Skill skill = new Skill("Java", "Java Fullstack");
		Skill skill2 = new Skill("Python", "Machin Learning,AI");
		Skill skill3 = new Skill("JavaScript", "Web Development");
		add(skill);
		add(skill2);
		add(skill3);
		System.out.println("Skills are added");
	}

	private Skill add(Skill skill) {
		skill = skillService.save(skill);
		return skill;
	}

}

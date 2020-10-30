package org.cap.apps.freelancerapp.ui;

import org.cap.apps.freelancerapp.util.JpaUtil;

public class ProjectMain {

	public static void main(String args[]) {
		ProjectMain project = new ProjectMain();
		project.execute();
	}

	public void execute() {
		AdminUI ui = new AdminUI();
		RecruiterUI recruiterui = new RecruiterUI();
		FreelancerUI freelancerui = new FreelancerUI();
		JobUI jobui = new JobUI();
		SkillUI skillui = new SkillUI();

		ui.runUi();
		recruiterui.recruiterUi();
		freelancerui.freelancerui();
		jobui.JobUi();
		skillui.SkillUi();

		JpaUtil jpaUtil = JpaUtil.getInstance();
		jpaUtil.close();

	}

}

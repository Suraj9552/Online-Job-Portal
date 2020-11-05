package org.cap.apps.freelancerapp.ui;

import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.jobms.service.IJobService;
import org.cap.apps.freelancerapp.jobms.service.JobServiceImpl;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.recruiterms.service.IRecruiterService;
import org.cap.apps.freelancerapp.recruiterms.service.RecruiterServiceImpl;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.skillms.service.ISkillService;
import org.cap.apps.freelancerapp.skillms.service.SkillServiceImpl;

public class JobUI {
	
	private IJobService jobService=new JobServiceImpl();
	private IRecruiterService recruiterservice = new RecruiterServiceImpl();
	private ISkillService skillservice = new SkillServiceImpl();
	
	public void JobUi() {
		Recruiter recruiter=new Recruiter("Athaarva","Jadhav","Atharva123");
		Skill skill=new Skill("Python","Machin Learning,AI");
		skill=skillservice.save(skill);
		recruiter = recruiterservice.save(recruiter);
		
		add(skill,recruiter);
		System.out.println("Job Posted");
		
	}
	private Job add(Skill skill,Recruiter recruiter) {
		
		Job job=jobService.postJob(skill, recruiter);
		return job;
	}
	


}
package org.cap.apps.freelancerapp.bookmarkjobms.service;

import org.cap.apps.freelancerapp.bookmarkjobms.entities.BookmarkedJob;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

import java.util.List;

public interface IBookmarkJobService {

    BookmarkedJob bookmarkJob(Job job, Freelancer freelancer) ;

    List<BookmarkedJob> findBookmarkedJobsBySkill(Skill skill, Freelancer freelancer) ;

    void removeBookmark(Job job, Freelancer freelancer);
}

package org.cap.apps.freelancerapp.bookmarkjobms.dao;

import org.cap.apps.freelancerapp.bookmarkjobms.entities.BookmarkedJob;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

import java.util.List;

public interface IBookmarkJobDao {

    BookmarkedJob save(BookmarkedJob job);


    void remove(BookmarkedJob job);

    List<BookmarkedJob> findBookmarkedJobsBySkill(Skill skill, Freelancer freelancer);


    BookmarkedJob findById(Long id);


}

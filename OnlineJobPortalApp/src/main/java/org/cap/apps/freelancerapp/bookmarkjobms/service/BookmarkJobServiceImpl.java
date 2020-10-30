package org.cap.apps.freelancerapp.bookmarkjobms.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.cap.apps.freelancerapp.bookmarkjobms.dao.BookmarkedJobDaoImpl;
import org.cap.apps.freelancerapp.bookmarkjobms.dao.IBookmarkJobDao;
import org.cap.apps.freelancerapp.bookmarkjobms.entities.BookmarkedJob;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.util.JpaUtil;

public class BookmarkJobServiceImpl implements IBookmarkJobService {
	private IBookmarkJobDao dao;
	private EntityManager entityManager;

	public BookmarkJobServiceImpl() {
		JpaUtil jpaUtil = JpaUtil.getInstance();
		entityManager = jpaUtil.getEntityManager();
		dao = new BookmarkedJobDaoImpl(entityManager);
	}

	@Override
	public BookmarkedJob bookmarkJob(Job job, Freelancer freelancer) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		BookmarkedJob bookmarkedJob = new BookmarkedJob(job, freelancer);
		bookmarkedJob = dao.save(bookmarkedJob);
		transaction.commit();
		return bookmarkedJob;
	}

	@Override
	public List<BookmarkedJob> findBookmarkedJobsBySkill(Skill skill, Freelancer freelancer) {
		List<BookmarkedJob> list = dao.findBookmarkedJobsBySkill(skill, freelancer);

		return list;
	}

	@Override
	public void removeBookmark(Job job, Freelancer freelancer) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		BookmarkedJob bookmarkedJob = new BookmarkedJob(job, freelancer);
		transaction.commit();
	}

}
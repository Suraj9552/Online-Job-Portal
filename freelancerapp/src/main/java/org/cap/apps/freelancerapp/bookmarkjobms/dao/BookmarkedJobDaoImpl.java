package org.cap.apps.freelancerapp.bookmarkjobms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.bookmarkjobms.entities.BookmarkedJob;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

public class BookmarkedJobDaoImpl implements IBookmarkJobDao {
	private EntityManager entityManager;

	public BookmarkedJobDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/* Saving details of job */

	@Override
	public BookmarkedJob save(BookmarkedJob job) {
		entityManager.persist(job);
		return job;
	}

	/* Removing details of job */
	@Override
	public void remove(BookmarkedJob job) {
		String sql = "DELETE FROM UserDetails WHERE job= :job";
		Query query = entityManager.createQuery(sql);
		query.setParameter("job", job);
		query.executeUpdate();

	}

	/* Added list of bookmarked job */
	@Override
	public List<BookmarkedJob> findBookmarkedJobsBySkill(Skill skill, Freelancer freelancer) {
		String ql = "from Job where skill = :skill && freelancer=:frelancer";
		TypedQuery<BookmarkedJob> query = entityManager.createQuery(ql, BookmarkedJob.class);
		query.setParameter("skill", skill);
		query.setParameter("freelancer", freelancer);
		List<BookmarkedJob> list = query.getResultList();
		return list;
	}

	/* Finding the job by id */
	@Override
	public BookmarkedJob findById(Long id) {
		BookmarkedJob bookmarkedJob = entityManager.find(BookmarkedJob.class, id);
		return bookmarkedJob;
	}

}
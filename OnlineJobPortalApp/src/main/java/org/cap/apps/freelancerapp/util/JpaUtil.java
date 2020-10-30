package org.cap.apps.freelancerapp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

/**
 * singleton class , only one instance of this class exits constructor is
 * private so if anyone needs instance of this. use getInstance() method
 */
public class JpaUtil {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobPortalms");

	private Set<EntityManager> entityManagers = new HashSet<>();

	private JpaUtil() {

	}

	private static JpaUtil instance = new JpaUtil();

	public static JpaUtil getInstance() {
		return instance;
	}

	public EntityManager getEntityManager() {
		EntityManager entityManager = emf.createEntityManager();
		entityManagers.add(entityManager);
		return entityManager;
	}

	public void close() {
		for (EntityManager manager : entityManagers) {
			manager.close();
		}
		emf.close();
	}

}

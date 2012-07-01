/**
 * 
 */
package org.icm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author nvejja
 * 
 */
@Repository
public class BaseDAOImpl {

	private EntityManager entityManager;

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}


	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Session getSession() {

		org.hibernate.Session session = (Session) entityManager.getDelegate();

		return session;
	}

}

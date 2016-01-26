package org.jrue.poc.springhibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class JpaGenericDao<E, K> implements GenericDao<E, K> {

	@PersistenceContext
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}

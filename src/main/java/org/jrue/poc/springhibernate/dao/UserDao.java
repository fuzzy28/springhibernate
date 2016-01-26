package org.jrue.poc.springhibernate.dao;

import java.util.List;

import org.jrue.poc.springhibernate.domain.User;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends JpaGenericDao<User, String> {
	
	@SuppressWarnings("unchecked")
	@Override
	public User findSingle(String key) {		
		return DataAccessUtils.singleResult(entityManager.createQuery("FROM User WHERE NAME = :name")
				   .setParameter("name", key).getResultList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return (List<User>) entityManager.createQuery("FROM User");
	}

	@Override
	public void save(User record) {
		entityManager.persist(record);
	}

	@Override
	public void update(User record) {
		entityManager.merge(record);
	}

	@Override
	public void delete(String record) {		
		entityManager.remove(findSingle(record));
	}
}
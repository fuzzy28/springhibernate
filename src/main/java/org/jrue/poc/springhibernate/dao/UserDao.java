package org.jrue.poc.springhibernate.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.jrue.poc.springhibernate.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends HibernateGenericDao<User, String> {
	
	@Override
	public User findSingle(String key) {
		return (User)getCurrentSession().createCriteria(User.class)
								  .add(Restrictions.eq("name", key))								  
								  .uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {		
		return getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public void save(User record) {
		getCurrentSession().save(record);
	}

	@Override
	public void update(User record) {
		getCurrentSession().update(record);
	}

	@Override
	public void delete(String record) {		
		getCurrentSession().delete(findSingle(record));
	}
}
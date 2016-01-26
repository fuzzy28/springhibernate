package org.jrue.poc.springhibernate.service;

import java.util.List;

import org.jrue.poc.springhibernate.dao.GenericDao;
import org.jrue.poc.springhibernate.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends GenericService<User, String> {

	@Autowired
	public UserService(GenericDao<User,String> userDao) {
		super(userDao);
	}

	@Override
	public User findSingle(String key) {
		return dao.findSingle(key);
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(User record) {
		User usr = findSingle(record.getName());
		if(usr != null && !usr.getName().isEmpty()) {
			throw new DuplicateKeyException(usr.getName() + " already exists!");
		} else {
			dao.save(record);
		}
	}

	@Override
	public void update(User record) {
		dao.update(record);
	}

	@Override
	@Transactional
	public void delete(String key) {
		dao.delete(key);
	}
}
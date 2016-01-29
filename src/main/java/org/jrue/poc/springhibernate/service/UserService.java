package org.jrue.poc.springhibernate.service;

import java.util.List;

import org.jrue.poc.springhibernate.domain.User;

/**
 * This service provides CRUD operations for {@link User} entity
 * @author jruelos
 *
 */
public interface UserService {

	 void delete(User deleted);

	 List<User> findAll();
    
	 User findOne(Long id);

	 User findByName(String name);
	 
	 User save(User persisted);
	 
	 User findByNameAndPassword(String name, String password);
}

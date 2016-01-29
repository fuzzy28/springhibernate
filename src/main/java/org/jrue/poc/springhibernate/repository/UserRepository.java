package org.jrue.poc.springhibernate.repository;

import org.jrue.poc.springhibernate.domain.User;

/**
 * Database Operations specific for Entity {@User}
 * Spring Data Jpa will provide implementation on the fly. 
 * 
 * @author jruelos
 *
 */
public interface UserRepository extends BaseRepository<User, Long> {
	
	public User findByName(String name);
	
	public User findByNameAndPassword(String name, String password);

}
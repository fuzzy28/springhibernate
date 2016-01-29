package org.jrue.poc.springhibernate.repository;

import org.jrue.poc.springhibernate.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {
	
	public User findByName(String name);
	
	public User findByNameAndPassword(String name, String password);

}
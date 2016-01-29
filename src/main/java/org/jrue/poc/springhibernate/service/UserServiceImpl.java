package org.jrue.poc.springhibernate.service;

import java.util.List;
import org.jrue.poc.springhibernate.domain.User;
import org.jrue.poc.springhibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Provide implementation of UserService interface which delegates
 * the implemented methods to User Repository.
 * 
 * @author jruelos
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void delete(User deleted) {
		userRepository.delete(deleted);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User save(User persisted) {
		return userRepository.save(persisted);
	}

	@Override
	public User findByName(String name) {	
		return userRepository.findByName(name);
	}

	@Override
	public User findByNameAndPassword(String name, String password) {
		return userRepository.findByNameAndPassword(name, password);
	}
}
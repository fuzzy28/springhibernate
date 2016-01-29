package org.jrue.poc.springhibernate.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * Base Repository for Basic CRUD Operations
 * @author jruelos
 *
 * @param <T> Entity Name
 * @param <ID> Unique type 
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

	 void delete(T deleted);
 
	 List<T> findAll();
     
	 T findOne(ID id);
 
	 T save(T persisted);
}

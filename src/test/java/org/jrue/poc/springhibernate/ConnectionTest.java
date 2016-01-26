package org.jrue.poc.springhibernate;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring-config.xml")
public class ConnectionTest {

	@PersistenceContext
	private EntityManager emf;
	
	@After
	public void destroy() {
		emf = null;
	}
	
	@Test
	public void testConnectivity() throws SQLException {	
		Assert.assertNotNull(emf);
	}
	
}
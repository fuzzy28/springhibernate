package org.jrue.poc.springhibernate;

import java.sql.SQLException;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring-config.xml")
public class ConnectionTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@After
	public void destroy() {
		sessionFactory = null;
	}
	
	@Test
	public void testConnectivity() throws SQLException {	
		Assert.assertNotNull(sessionFactory);
	}
	
}
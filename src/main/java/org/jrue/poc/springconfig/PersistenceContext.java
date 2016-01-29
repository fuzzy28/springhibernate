package org.jrue.poc.springconfig;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * DataSource, Repository and Transaction management Configuration
 * Database connection is loaded from database.properties configuration file
 * @author jruelos
 *
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableJpaRepositories("org.jrue.poc.springhibernate.repository") 
@EnableTransactionManagement
public class PersistenceContext {

	@Value("${db.driver}")
	private String driverClassName;
	
	@Value("${db.url}")	
	private String url;
	
	@Value("${db.username}")	
	private String username;
	
	@Value("${db.password}")	
	private String password;
	
	@Value("${db.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private boolean show_sql;
	
	@Value("${hibernate.format_sql}")
	private boolean format_sql;
	
	@Bean
	@Primary
	public DataSource getDatasource() {	
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		return new HikariDataSource(config);
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new
					LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(getDatasource());
		entityManager.setPackagesToScan("org.jrue.poc.springhibernate.domain");
		entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties jpaProps = new Properties();
		jpaProps.put("hibernate.show_sql", String.valueOf(show_sql));
		jpaProps.put("hibernate.dialect", dialect);
		jpaProps.put("hibernate.format_sql", String.valueOf(format_sql));
		entityManager.setJpaProperties(jpaProps);
		return entityManager;
	}
	
	@Bean
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {;
		return new JpaTransactionManager(emf);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
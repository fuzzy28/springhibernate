package org.jrue.poc.springconfig;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"org.jrue.poc"})
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class AppConfig {

	@Value("${db.driver}")
	private String driverClassName;
	
	@Value("${db.url}")	
	private String url;
	
	@Value("${db.username}")	
	private String username;
	
	@Value("${db.password}")	
	private String password;
	
	@Value("${db.initialsize}")
	private int initialSize;
	
	@Value("${db.dialect}")
	private String dialect;
	
	@Bean
	@Primary
	public DataSource getDatasource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(driverClassName);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setInitialSize(initialSize);		
		return datasource;
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean entityManager = new
					LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(getDatasource());
		entityManager.setPackagesToScan("org.jrue.poc.springhibernate.domain");
		entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties jpaProps = new Properties();
		jpaProps.put("show_sql", "true");
		jpaProps.put("dialect", dialect);
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
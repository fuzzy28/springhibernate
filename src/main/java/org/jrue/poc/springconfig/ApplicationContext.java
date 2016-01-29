package org.jrue.poc.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * Main Application Configuration
 * @author jruelos
 *
 */
@Import({PersistenceContext.class, LoggingAspect.class})
@ComponentScan(basePackages = {"org.jrue.poc"})
@EnableAspectJAutoProxy
public class ApplicationContext {
	
}

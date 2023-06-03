package com.rft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
Main class for the RssFeedsTracker application.
*/
@SpringBootApplication
@EnableJpaRepositories("com.rft.repository")
@EntityScan("com.rft.model") 
@EnableTransactionManagement
@EnableIntegration
public class RssFeedsTrackerApplication {

	public static void main(String[] args) {
	        ConfigurableApplicationContext context = SpringApplication.run(RssFeedsTrackerApplication.class, args);

	        // Keep the application running until manually terminated
	        context.registerShutdownHook();
	    }

}

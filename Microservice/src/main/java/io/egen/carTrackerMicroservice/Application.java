package io.egen.carTrackerMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.egen.config.JavaEmailAppConfig;

@SpringBootApplication(scanBasePackages={ "io.egen"})
@EnableAutoConfiguration
@ComponentScan(basePackages = { "io.egen.carTrackerMicroservice", "io.egen.controller", "io.egen.exception",
		"io.egen.entity", "io.egen.config", "io.egen.repository", "io.egen.service"})
@Import({ JavaEmailAppConfig.class })
@EnableJpaRepositories("io.egen.repository") 
@EntityScan(basePackages={ "io.egen.carTrackerMicroservice", "io.egen.controller", "io.egen.exception",
		"io.egen.entity", "io.egen.config", "io.egen.repository", "io.egen.service"})
public class Application {
	public static void main(String[] args) {
		//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication.run(Application.class, args);
	}
}

package com.hileco.blegex.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * It acts as a @Configuration class for Spring.
 * As such it has @ComponentScan annotation that enables scanning for another Spring components in current package and its subpackages.
 * Another annotation is @EnableAutoConfiguration which tells Spring Boot to run autoconfiguration.
 * It also extends SpringBootServletInitializer which will configure Spring servlet for us, and overrides the configure() method to point to itself, so Spring can find the main configuration.
 * Finally, the main() method consists of single static call to SpringApplication.run().
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
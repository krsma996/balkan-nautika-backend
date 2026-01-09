package com.balkan.nautical.systems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@PropertySource("file:${pho.home.directory}/application.properties")
public class BalkanNauticalSpringBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BalkanNauticalSpringBootApplication.class, args);
	}
}

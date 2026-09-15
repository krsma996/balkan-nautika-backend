package com.balkan.nautical.systems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.balkan.nautical.systems.utils.BalkanNautikaMessageSource;

@Configuration
public class MessageSourceConfig {

	@Bean
	public BalkanNautikaMessageSource messageSource() {
		BalkanNautikaMessageSource messageSource = new BalkanNautikaMessageSource();
		messageSource.setBasename("messages/messages");
		messageSource.setDefaultEncoding("UTF-8");

		return messageSource;
	}

}

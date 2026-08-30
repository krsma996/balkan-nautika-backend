package com.balkan.nautical.systems.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



/*
 @author Nikola Krsmanovic
  Web configurations 
 */


@Configuration
public class WebConfigurations {

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of(CorsConfiguration.ALL));
		configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", 
													  "Access-Control-Allow-Origin",
													  "Access-Control-Request-Method", 
													  "Access-Control-Request-Headers", 
													  "Origin", 
													  "Cache-Control",
													  "Content-Type", 
													  "Authorization"));
		configuration.setExposedHeaders(List.of("Content-Disposition", "Set-Cookie", "Content-Type"));
		configuration.setAllowedMethods(List.of("DELETE", "GET", "POST", "PATCH", "PUT", "OPTIONS"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
    }

    @Bean
    public CorsFilter corsFilter(
            CorsConfigurationSource corsConfigurationSource) {

        return new CorsFilter(corsConfigurationSource);
    }
}

package com.balkan.nautical.systems.config;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
	
	@Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    private class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.ofNullable(extractUsernameFromAuthentication());
        }

        public String extractUsernameFromAuthentication() {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null) {
                return "nautical-systems";
            }

            String username;
            if (authentication instanceof JwtAuthenticationToken token) {
                username = (String) token.getTokenAttributes().get("preferred_username");
            } else {
                username = authentication.getName();
            }
            return username;
        }
    }

}
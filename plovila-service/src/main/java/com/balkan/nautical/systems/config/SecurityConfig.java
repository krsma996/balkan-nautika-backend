package com.balkan.nautical.systems.config;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;


/*
 * @author Nikola Krsmanovic
 * 
 *  Main entry for Security Configuration 
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	    @Bean
	    SecurityFilterChain securityFilterChain(
	            HttpSecurity http,
	            Converter<Jwt, AbstractAuthenticationToken> jwtConverter,
	            CorsConfigurationSource corsConfigurationSource
	    ) throws Exception {

	        return http
	                .cors(cors -> cors.configurationSource(corsConfigurationSource))
	                .csrf(csrf -> csrf.disable())
	                .sessionManagement(session -> session
	                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                )
	                .authorizeHttpRequests(auth -> auth
	                        .requestMatchers("/api/public/**").permitAll()
	                        .requestMatchers(HttpMethod.GET, "/api/listings/**").permitAll()
	                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
	                        .requestMatchers("/api/**").authenticated()
	                        .anyRequest().permitAll()
	                )
	                .oauth2ResourceServer(oauth2 -> oauth2
	                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter))
	                )
	                .build();
	    }

	    @Bean
	    Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {
	        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

	        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
	            Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");

	            if (realmAccess == null) {
	                return Collections.emptyList();
	            }

	            Object rolesObject = realmAccess.get("roles");

	            if (!(rolesObject instanceof Collection<?> roles)) {
	                return Collections.emptyList();
	            }

	            return roles.stream()
	                    .map(Object::toString)
	                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
	                    .collect(Collectors.toSet());
	        });

	        converter.setPrincipalClaimName("preferred_username");
	        return converter;
	    }
	
}

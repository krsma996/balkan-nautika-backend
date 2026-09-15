package com.balkan.nautical.systems.config;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            org.springframework.web.cors.CorsConfigurationSource corsConfigurationSource
    ) throws Exception {

        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource))
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                // Public endpoints
                .requestMatchers("/v3/api-docs/**","/swagger-ui/**","/swagger-ui.html","/actuator/**").permitAll()
                // Everything else requires JWT
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 ->
                oauth2.jwt(jwt ->
                    jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                )
            );

        return http.build();
    }

    @Bean
    Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {

        JwtAuthenticationConverter converter =
            new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(jwt -> {

            Map<String, Object> realmAccess =
                jwt.getClaimAsMap("realm_access");

            if (realmAccess == null) {
                return Collections.emptySet();
            }

            Object rolesObject = realmAccess.get("roles");

            if (!(rolesObject instanceof Collection<?> roles)) {
                return Collections.emptySet();
            }

            return roles.stream()
                .map(Object::toString)
                .map(role ->
                    new SimpleGrantedAuthority("ROLE_" + role)
                )
                .collect(Collectors.toSet());
        });

        converter.setPrincipalClaimName("preferred_username");

        return converter;
    }
}
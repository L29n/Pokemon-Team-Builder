package com.pokemon_team_builder.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration of the security on endpoints.
 */
@Configuration
public class WebSecurityConfig {

    /**
     * Filter chain to configure security.
     *
     * @param http The security object.
     * @return The chain built.
     * @throws Exception Thrown on error configuring.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //TODO: Proper authentication.
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable());
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }

}

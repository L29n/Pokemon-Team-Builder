package com.pokemon_team_builder.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**") //Configured settings for all endpoints
                        .allowedOrigins("http://localhost:3000") // Allowed point of origin for requests
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Type of allowed requests
                        .allowedHeaders("*") // Allows all request headers formats
                        .allowCredentials(true) // Credentials are allowed in CORS
                        .maxAge(3600);
            }
        };
    }
}

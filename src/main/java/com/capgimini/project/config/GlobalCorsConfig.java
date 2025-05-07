package com.capgimini.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // allow all endpoints
                        .allowedOrigins("http://127.0.0.1:5501") // your frontend origin
                        .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}

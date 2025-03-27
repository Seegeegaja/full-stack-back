package com.my.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("api/**")
                        .allowedMethods("GET", "POST")
                        .allowedOrigins("http://seegeegaja-front-app.s3-website-ap-southeast-2.amazonaws.com")//react 서버주소
                        .allowCredentials(true);
            }
        };
    }
}

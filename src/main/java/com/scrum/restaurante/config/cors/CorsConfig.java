package com.scrum.restaurante.config.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite todas as rotas
                .allowedOrigins("http://localhost:3000/") // Permite todas as origens
                .allowedMethods("*") // Permite todos os métodos (GET, POST, PUT, DELETE, etc.)
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true);
    }
}


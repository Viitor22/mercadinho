package com.mercadinho.mercadinhoV2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Mapeia para todas as URLs
            .allowedOrigins("*") // Permite solicitações de qualquer origem
            .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite os métodos HTTP especificados
            .allowedHeaders("*"); // Permite todos os cabeçalhos HTTP
    }
}

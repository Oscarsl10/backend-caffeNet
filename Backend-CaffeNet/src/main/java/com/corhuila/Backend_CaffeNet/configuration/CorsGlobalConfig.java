package com.corhuila.Backend_CaffeNet.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsGlobalConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        // 1. Defino la fuente de configuración CORS
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // 2. Configuro la política
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);               // Permite cookies/credenciales
        config.addAllowedOriginPattern("http://localhost:8100");   // Acepta dominio del frontend
        config.addAllowedHeader("*");                   // Acepta cualquier header
        config.addAllowedMethod("*");                   // Acepta cualquier método (GET, POST, etc.)

        // 3. Aplico la config a todos los endpoints
        source.registerCorsConfiguration("/**", config);

        // 4. Registro el filtro con máxima prioridad (orden HIGHEST_PRECEDENCE)
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
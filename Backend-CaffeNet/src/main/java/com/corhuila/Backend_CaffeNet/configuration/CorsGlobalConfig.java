package com.corhuila.Backend_CaffeNet.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@Configuration
public class CorsGlobalConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        // Origen de la configuración CORS
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Configuración de CORS
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);                       // Permitir credenciales (cookies, headers, etc.)
        config.setAllowedOriginPatterns(Collections.singletonList("*")); // Cualquier dominio y cualquier puerto
        config.setAllowedHeaders(Collections.singletonList("*"));        // Todos los headers permitidos
        config.setAllowedMethods(Collections.singletonList("*"));        // Todos los métodos HTTP permitidos

        // Aplica esta configuración a todos los endpoints
        source.registerCorsConfiguration("/**", config);

        // Registra el filtro CORS con la prioridad más alta
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
package com.corhuila.Backend_CaffeNet.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsGlobalConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        // Fuente de configuración CORS
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Configuración de CORS
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);  // Necesario para cookies/autenticación

        // SOLO orígenes explícitos (¡sin asterisco!)
        config.setAllowedOrigins(Arrays.asList(
                "http://localhost",
                "https://localhost",
                "capacitor://localhost",
                "http://localhost:8100"  // si usas Angular local
        ));

        config.setAllowedHeaders(Collections.singletonList("*"));   // Permitir todos los headers
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos permitidos

        // Aplicar config a todos los endpoints
        source.registerCorsConfiguration("/**", config);

        // Registrar el filtro
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
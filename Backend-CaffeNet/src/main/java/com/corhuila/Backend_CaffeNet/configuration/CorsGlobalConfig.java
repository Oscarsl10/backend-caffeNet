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
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Permitir credenciales (cookies, sesiones)
        config.setAllowCredentials(true);

        // ✅ Orígenes permitidos (incluye el que aparece en tu error: https://localhost)
        config.setAllowedOrigins(Arrays.asList(
                "https://localhost",           // navegador con HTTPS (tu caso)
                "http://localhost",            // navegador sin HTTPS
                "capacitor://localhost"        // apps móviles nativas
        ));

        // ✅ Métodos y headers
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setExposedHeaders(Arrays.asList("Authorization"));

        // ✅ Aplica a todos los endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        // ✅ Registrar el filtro con prioridad alta
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
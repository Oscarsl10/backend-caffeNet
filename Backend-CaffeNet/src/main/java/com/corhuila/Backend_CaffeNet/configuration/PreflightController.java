package com.corhuila.Backend_CaffeNet.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreflightController {

    @RequestMapping(
            path = "/**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity<Void> preflight() {
        // Devuelve 200 OK y deja que el filtro CORS inyecte las cabeceras
        return ResponseEntity.ok().build();
    }
}

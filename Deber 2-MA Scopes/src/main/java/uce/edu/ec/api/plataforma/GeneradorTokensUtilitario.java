package uce.edu.ec.api.plataforma;

import jakarta.inject.Singleton;
import java.util.UUID;

// EXCLUSIVO PARA BEANS UTILITARIOS
@Singleton
public class GeneradorTokensUtilitario {
    
    public String generarTokenAcceso() {
        // Un utilitario simple que genera cadenas aleatorias, sin reglas de negocio
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
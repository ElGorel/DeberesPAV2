package uce.edu.ec.api.plataforma;

import jakarta.enterprise.context.ApplicationScoped;

// SERVICIO DE NEGOCIO QUE VIVE TODA LA APLICACIÓN
@ApplicationScoped
public class ServicioSuscripcionesNegocio {
    private int clientesActivos = 0;

    public int registrarNuevoCliente() {
        // Lógica de negocio: incrementa el contador global de la empresa
        return ++clientesActivos;
    }
}
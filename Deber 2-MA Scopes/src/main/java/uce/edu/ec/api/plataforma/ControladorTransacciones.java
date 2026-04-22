package uce.edu.ec.api.plataforma;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ControladorTransacciones {

    @Inject
    private GeneradorTokensUtilitario utilitarioToken; // Singleton

    @Inject
    private ServicioSuscripcionesNegocio servicioNegocioGlobal; // ApplicationScoped

    @Inject
    private CalculadoraCostosNegocio calculadoraCostosTemporal; // Dependent

    public void ejecutarProcesoSecundario() {
        System.out.println("\n--- EJECUTANDO DESDE CONTROLADOR (Clase Intermedia) ---");
        
        System.out.println("Utilitario (Singleton) generó token: " + utilitarioToken.generarTokenAcceso());
        
        // Continúa la cuenta donde se quedó
        System.out.println("Negocio Global (Application) - Clientes totales: " + servicioNegocioGlobal.registrarNuevoCliente());
        
        // Inicia desde cero porque esta clase recibió su propia instancia
        System.out.println("Negocio Temporal (Dependent) - Costo de este proceso: $" + calculadoraCostosTemporal.agregarServicioAdicional(15.0));
    }
}
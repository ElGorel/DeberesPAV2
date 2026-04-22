package uce.edu.ec.api.plataforma;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private GeneradorTokensUtilitario utilitario;

        @Inject
        private ServicioSuscripcionesNegocio servicioGlobal;

        @Inject
        private CalculadoraCostosNegocio miCalculadora;

        @Inject
        private ControladorTransacciones controlador;

        @Override
        public int run(String... args) {
            System.out.println("\n============= INICIANDO PLATAFORMA =============");
            
            System.out.println("********** PRUEBA UTILITARIO (SINGLETON) **********");
            System.out.println("Token Main 1: " + utilitario.generarTokenAcceso());
            System.out.println("Token Main 2: " + utilitario.generarTokenAcceso());

            System.out.println("\n********** PRUEBA NEGOCIO GLOBAL (APPLICATION) **********");
            System.out.println("Cliente registrado. Total: " + servicioGlobal.registrarNuevoCliente());
            System.out.println("Cliente registrado. Total: " + servicioGlobal.registrarNuevoCliente());

            System.out.println("\n********** PRUEBA NEGOCIO TEMPORAL (DEPENDENT) **********");
            System.out.println("Costo actual Main: $" + miCalculadora.agregarServicioAdicional(50.0));
            System.out.println("Costo actual Main: $" + miCalculadora.agregarServicioAdicional(20.0));

            // Llamamos al controlador para comprobar los alcances
            controlador.ejecutarProcesoSecundario();

            System.out.println("\n================================================\n");
            return 0;
        }
    }
}
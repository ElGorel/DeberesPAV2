package uce.edu.ec.api.bodega;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        // Arranca Quarkus usando la clase interna App
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        // 1. Inyección de Dependencias (DI) mediante anotación
        @Inject
        ContadorServicio contadorInyectado;

        @Override
        public int run(String... args) {
            System.out.println("=== DEMOSTRACIÓN DE IOC Y SCOPES ===");

            // 2. Localizador de Servicios (Lookup manual por CDI)
            // Esto busca el Bean directamente en el contenedor
            ContadorServicio contadorPorLookup = CDI.current().select(ContadorServicio.class).get();

            // CASO 1: Usamos la instancia inyectada automáticamente
            System.out.println("Uso 1 (Inyectado): Valor = " + contadorInyectado.incrementar());

            // CASO 2: Usamos la instancia obtenida manualmente por Lookup
            System.out.println("Uso 2 (Lookup): Valor = " + contadorPorLookup.incrementar());

            // CASO 3: Probamos una vez más para confirmar el @ApplicationScoped
            System.out.println("Uso 3 (Inyectado de nuevo): Valor = " + contadorInyectado.incrementar());

            System.out.println("====================================");
            System.out.println("NOTA: Como usamos @ApplicationScoped, ambos objetos son el mismo.");
            System.out.println("Por eso el conteo es consecutivo (1, 2, 3).");
            
            return 0;
        }
    }
}
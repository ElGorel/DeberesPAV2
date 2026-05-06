package uce.edu.ec.api.bodega;

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
        ProcesadorCompraService compraService;

        
        @Override
        public int run(String... args) {
            Compra comp1 = new Compra("Marco Andrade", 100);
            this.compraService.procesar(comp1);
            
            return 0;
        }
    }
}



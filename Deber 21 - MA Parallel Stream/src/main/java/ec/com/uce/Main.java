package ec.com.uce;

import java.util.ArrayList;
import java.util.List;

import ec.com.uce.application.service.ProductoService;
import ec.com.uce.domain.model.Producto;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

    

        @Inject
        private ProductoService productoService;

        @Override
        public int run(String... args) throws Exception {
            
            List<Producto> lista = new ArrayList<>();

            for(int i=0; i<500000; i++){
                Producto p1 = new Producto();
                p1.setNombre("Producto de Prueba" + i);
                lista.add(p1);
            }

            //this.productoService.guardarListaProductos(lista);
            this.productoService.guardarListaProductosParalelo(lista);
 
            return 0;
        }
    }
}
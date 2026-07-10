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


public static void main(String... args){

    Quarkus.run(App.class,args);


}

    public static class App implements QuarkusApplication{
       
        @Inject
       private ProductoService productoService;
       
        @Override
        public int run(String... args){

            List<Producto> lista = new ArrayList<>();

           for(int i = 0;i<50;i++){ // limitado a 50 para que se pueda ver en los logs, con 500 no aparecia el cronometro por la limitacion de la terminal 

            Producto p1 = new Producto();
            p1.setNombre("producto");
            p1.setCategoria("categoria");
            p1.setPrecio(10.0);
            p1.setStock(100);
            lista.add(p1);

           }

            

            this.productoService.guardarListaProductos(lista);
            


            return 0;
        }
    }

}

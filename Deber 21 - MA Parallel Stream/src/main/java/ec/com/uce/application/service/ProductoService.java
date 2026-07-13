package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Producto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ProductoService {

    @MedirTiempo
     public void guardarProducto(Producto producto){
        
        //String nombrehiloProductos = Thread.currentThread().getName();

            //System.out.println("nombre del hilo productos  " + nombrehiloProductos);
            //System.out.println("ID: "+ Thread.currentThread().threadId());
        
       
       
       
        producto.persist();
    }


    @MedirTiempo
    public void guardarListaProductos(List<Producto> lista){

        for(Producto p : lista){
            this.guardarProducto(p);
        }



    }


    @MedirTiempo
    public void guardarListaProductosParalelo(List<Producto> lista){
        lista.parallelStream().forEach(producto -> {
            //aqui programo toda la logica que quiero que se aplique a cada item de la lista
            this.guardarProducto(producto);
        });
    }



}

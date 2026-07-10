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
        
        String nombrehiloProductos = Thread.currentThread().getName();

            System.out.println("nombre del hilo productos  " + nombrehiloProductos);
            System.out.println("ID: "+ Thread.currentThread().threadId());
        
        try {
            Thread.sleep(10);
        } catch (Exception e) {
        }
        
       
       
        producto.persist();
    }


    @MedirTiempo
    public void guardarListaProductos(List<Producto> lista){

        for(Producto p : lista){
            this.guardarProducto(p);
        }



    }



}

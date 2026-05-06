package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InventarioService {

     @MedirTiempo
    public void procesarInventario (Venta venta){
        
        
        //inicia inventario

        System.out.println("Se inicia el procesado de inventario......");
        //consultando Stock
        //consultando base de datos....  etc 

        //simulamos tiempo de demora
        try{

            Thread.sleep(500);
            
        }catch (Exception e){

        }
        
    
        System.out.println("Final del Procesamiento de inventario ");

    }


}

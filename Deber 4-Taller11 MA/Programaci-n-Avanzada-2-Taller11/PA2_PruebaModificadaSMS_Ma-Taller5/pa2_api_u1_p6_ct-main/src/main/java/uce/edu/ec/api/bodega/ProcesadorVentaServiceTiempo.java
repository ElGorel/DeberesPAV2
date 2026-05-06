package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProcesadorVentaServiceTiempo {
    
    
    
    //@Inject
    //private EstadisticasVentasGlobales estadisticasVentasGlobales;

    
    @MedirTiempo
    @Log
    public void procesar (Venta venta){
        
        //ensusiamos logica de negocio
        //System.out.println("Entro al metodo con los siguientes valores: " + venta.getCliente());

        //inicia venta

        System.out.println("procesando pedido......");
        //consultando Stock
        //consultando base de datos....  etc 

        //simulamos tiempo de demora
        try{

            Thread.sleep(100);
            
        }catch (Exception e){

        }
        
        //this.estadisticasVentasGlobales.registrarVenta(venta.getTotal());
        System.out.println("Final del pedido");

        //this.reprocesar(venta);  //no se ejecuta el interceptor pues es una llamada interna ( En Quarkus si )

    }


     @MedirTiempo
    public void reprocesar (Venta venta){
        
        
        //inicia venta

        System.out.println("reprocesando pedido......");
        //consultando Stock
        //consultando base de datos....  etc 

        //simulamos tiempo de demora
        try{

            Thread.sleep(250);
            
        }catch (Exception e){

        }
        
       // this.estadisticasVentasGlobales.registrarVenta(venta.getTotal());
        System.out.println("Final del reproceso");

    }
}

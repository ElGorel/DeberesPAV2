package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class ProcesadorVentaService {
    
    @Inject
    private TrakingVenta trakingVenta;
 
    
    @Inject
    private EstadisticasVentasGlobales estadisticasVentasGlobales;
 
 
    public void procesar (Venta venta){
        
        
        this.trakingVenta.iniciar();
        //inicia venta

        System.out.println("procesando pedido......");
        //consultando Stock
        //consultando base de datos....  etc 

        //simulamos tiempo de demora
        try{

            Thread.sleep(100);
            
        }catch (Exception e){

        }
        



        // finaliza venta
        this.trakingVenta.finalizar();

        this.estadisticasVentasGlobales.registrarVenta(venta.getTotal());;

    }
}

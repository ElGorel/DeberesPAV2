package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;



@ApplicationScoped
public class ProcesadorCompraService {

        
        @Inject
        private Instance<Descuento> descuentos;

        @Inject
        private Instance<Impuesto> impuestos;

    public void procesar(Compra compra){

        double total = compra.getSubTotal();

        for (Impuesto imp : impuestos){
            total = imp.calcular(total);
        }
        for (Descuento des : descuentos){
            
            total = des.aplicar(total);
            
        }
        
        compra.setTotal(total);

        System.out.println("Su valor a pagar es. " + compra.getTotal());
    }


}

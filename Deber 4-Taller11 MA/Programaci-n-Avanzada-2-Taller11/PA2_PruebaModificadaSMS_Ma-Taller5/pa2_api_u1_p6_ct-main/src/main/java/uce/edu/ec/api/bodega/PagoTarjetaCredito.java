package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagoTarjetaCredito implements PagoEstrategia{

    @Override
    public void realizar(double valor) {
        
        System.out.println("Presenta la pantalla para datos de tarjeta");
        System.out.println("Realizando cobro");

        
    }

    
}

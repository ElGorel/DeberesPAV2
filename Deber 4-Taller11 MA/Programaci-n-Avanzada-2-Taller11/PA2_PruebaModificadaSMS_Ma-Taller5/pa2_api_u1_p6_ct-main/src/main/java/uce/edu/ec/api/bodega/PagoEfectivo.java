package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagoEfectivo implements PagoEstrategia{

    @Override
    public void realizar(double valor) {
        
        System.out.println("Presenta una pantalla");
        System.out.println("Cobro realizado");
        
    }

}

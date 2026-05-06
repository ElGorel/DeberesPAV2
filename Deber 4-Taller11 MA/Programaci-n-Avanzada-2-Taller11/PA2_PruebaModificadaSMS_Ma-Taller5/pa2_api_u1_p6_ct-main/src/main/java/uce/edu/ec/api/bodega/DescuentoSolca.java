package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DescuentoSolca implements Descuento{

    @Override
    public double aplicar(double valor) {
        
         System.out.println("Aplicando Solca");
       double valorADescontar = valor * 0.20;
        return valor - valorADescontar;
    }



}

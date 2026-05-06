package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DescuentoBlackFriday implements Descuento{

    @Override
    public double aplicar(double valor) {
          System.out.println("Aplicando BlackFriday");
       double valorADescontar = valor * 0.05;
        return valor - valorADescontar;
    }



}

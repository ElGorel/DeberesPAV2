package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImpuestoIESS implements Impuesto {
    @Override
    public double calcular(double valor) {
        System.out.println("Aplicando Impuesto IESS");
        return valor * 1.07;
    }
}

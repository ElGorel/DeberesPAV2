package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImpuestoSRI implements Impuesto {
    @Override
    public double calcular(double valor) {
        System.out.println("Aplicando Impuesto SRI");
        return valor * 1.10;
    }
}

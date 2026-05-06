package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImpuestoBomberos implements Impuesto {

    @Override
    public double calcular(double valor) {
        System.out.println("Aplicando Impuesto Bomberos");
        return valor * 1.05;
    }
}

package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.Dependent;

@Dependent
public class AmbitoInject {
private int contador=0;
 
    public int incrementar() {
        return contador++;
    }
}

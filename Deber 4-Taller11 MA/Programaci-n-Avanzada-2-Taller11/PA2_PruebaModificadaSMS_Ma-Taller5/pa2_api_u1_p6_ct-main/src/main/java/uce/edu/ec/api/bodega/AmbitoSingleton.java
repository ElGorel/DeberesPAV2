package uce.edu.ec.api.bodega;

import jakarta.inject.Singleton;

@Singleton
public class AmbitoSingleton {

    private int contador=0;
 
    public int incrementar() {
        return contador++;
    }
}

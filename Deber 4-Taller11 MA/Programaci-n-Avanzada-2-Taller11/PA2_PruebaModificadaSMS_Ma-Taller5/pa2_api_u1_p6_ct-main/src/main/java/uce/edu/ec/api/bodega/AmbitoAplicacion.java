package uce.edu.ec.api.bodega;
 
import jakarta.enterprise.context.ApplicationScoped;
 
@ApplicationScoped
public class AmbitoAplicacion {
    private int contador=0;
 
    public int incrementar() {
        return contador++;
    }
}
package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.Dependent;


@Dependent
public class TrakingVenta {

    private long tiempoInicio =0;
    
    private long tiempoFinal =0;
    
    public void iniciar(){

        this.tiempoInicio = this.tiempoInicio + System.currentTimeMillis();


    }

    public void finalizar(){

        this.tiempoFinal = this.tiempoFinal + System.currentTimeMillis();
        long tiempoEjecucion = tiempoFinal-tiempoInicio;

        System.out.println("tiempo ejecucion "+ tiempoEjecucion + "ms" );



    }

}

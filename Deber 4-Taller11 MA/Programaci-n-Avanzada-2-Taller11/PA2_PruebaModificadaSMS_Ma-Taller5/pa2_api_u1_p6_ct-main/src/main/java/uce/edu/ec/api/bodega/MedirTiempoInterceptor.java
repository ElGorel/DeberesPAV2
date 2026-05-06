package uce.edu.ec.api.bodega;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
//@Priority(2)
public class MedirTiempoInterceptor {

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {

        System.out.println("Se ejecuto antes del metodo"); 

        System.out.println("Metodo interceptado "+ context.getMethod().getName());
           
        long inicio = System.currentTimeMillis();
        
        // inicia la ejecucion del metodo
        // si no se llama a proceed, nunca se ejecuta el metodo 
        Object resultado = context.proceed();
        //pasa a la siguiente linea cuando se termine la ejecicion del metodo de negocio

        long fin = System.currentTimeMillis();


        long tiempoTranscurrido = fin - inicio;
        System.out.println("tiempo transcurrido: " + tiempoTranscurrido);

        return resultado;
    }


}

package uce.edu.ec.api.bodega;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
//@Priority(3)
public class LogInterceptor {

    @AroundInvoke
    public Object medir(InvocationContext context) throws Exception {

        System.out.println("Se ejecuto Log antes del metodo"); 
        
        System.out.println("Metodo interceptado: "+ context.getMethod().getName());
           
        
       Object[] args = context.getParameters();
       for (int i = 0; i < args.length; i++) {
            System.out.println("Argumento : " + args[i]);
            Object obj= args[i];
            Venta venta = (Venta) obj;
            System.out.println(venta.getCliente());
            System.out.println(venta.getTotal());
       }
        
        Object resultado = context.proceed();
        

       


        

        return resultado;
    }


}

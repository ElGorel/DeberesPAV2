package ec.com.uce.application.service.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo // Vincula este interceptor con la anotación creada arriba
@Interceptor
@Priority(Interceptor.Priority.APPLICATION) // Define la prioridad de ejecución
public class TiempoInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        // 1. Capturar el nombre del método interceptado
        String metodoNombre = context.getMethod().getName();
        String claseNombre = context.getMethod().getDeclaringClass().getSimpleName();

        // 2. Tiempo de inicio
        long tiempoInicio = System.currentTimeMillis();

        try {
            // 3. Permitir que el método original se ejecute
            return context.proceed();
        } finally {
            // 4. Tiempo final (se ejecuta siempre, ocurra o no un error)
            long tiempoFin = System.currentTimeMillis();
            long tiempoTotal = tiempoFin - tiempoInicio;

            System.out.println(">>> [CRONÓMETRO] " + claseNombre + "." + metodoNombre + " tardó " + tiempoTotal + " ms.");
        }
    }
}
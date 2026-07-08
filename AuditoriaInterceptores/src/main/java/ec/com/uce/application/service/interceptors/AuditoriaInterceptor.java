package ec.com.uce.application.service.interceptors;

import ec.com.uce.application.service.AuditoriaService;
import ec.com.uce.domain.model.Auditoria;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import java.time.LocalDateTime;

@Auditar
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class AuditoriaInterceptor {

    @Inject
    private AuditoriaService auditoriaService;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        // 1. Obtener datos del método
        String metodoNombre = context.getMethod().getDeclaringClass().getSimpleName() + "." + context.getMethod().getName();
        
        // 2. Obtener argumentos
        Object[] parameters = context.getParameters();
        StringBuilder sb = new StringBuilder();
        if (parameters != null && parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                sb.append(parameters[i] != null ? parameters[i].toString() : "null");
                if (i < parameters.length - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("none");
        }
        String argumentos = sb.toString();

        // 3. Capturar tiempo y fecha
        long tiempoInicio = System.currentTimeMillis();
        LocalDateTime fechaHora = LocalDateTime.now();

        try {
            // 4. Ejecutar el método original
            return context.proceed();
        } finally {
            // 5. Calcular tiempo de ejecución y persistir
            long tiempoFin = System.currentTimeMillis();
            long tiempoTotal = tiempoFin - tiempoInicio;

            Auditoria auditoria = new Auditoria();
            auditoria.setNombreMetodo(metodoNombre);
            auditoria.setArgumentos(argumentos);
            auditoria.setFechaHoraEjecucion(fechaHora);
            auditoria.setTiempoEjecucionMs(tiempoTotal);

            // Guardar auditoría a través del servicio
            this.auditoriaService.guardarAuditoria(auditoria);
        }
    }
}

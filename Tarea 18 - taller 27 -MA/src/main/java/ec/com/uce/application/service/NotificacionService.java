package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Notificacion;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class NotificacionService {

    @MedirTiempo
    public void enviarNotificacion(Notificacion notificacion) {
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo NotificacionS  " + nombrehilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        
        // Simular envío de notificación persistiendo en BD
        notificacion.persist();
    }
}

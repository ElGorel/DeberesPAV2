package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Pago;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PagoService {

    @MedirTiempo
    public void procesarPago(Pago pago) {
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo PagoS  " + nombrehilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        
        // Simular procesamiento del pago persistiendo en la BD
        pago.persist();
    }
}

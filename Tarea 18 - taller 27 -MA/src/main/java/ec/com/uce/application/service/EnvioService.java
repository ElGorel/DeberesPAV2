package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Envio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class EnvioService {

    @MedirTiempo
    public void prepararEnvio(Envio envio) {
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo EnvioS  " + nombrehilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        
        // Simular preparación de envío
        envio.persist();
    }
}

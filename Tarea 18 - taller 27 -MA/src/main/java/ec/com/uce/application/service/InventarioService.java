package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Inventario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class InventarioService {

    @MedirTiempo
    public void actualizarInventario(Inventario inventario) {
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo InventarioS  " + nombrehilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        
        // Simular reserva de stock
        inventario.persist();
    }
}

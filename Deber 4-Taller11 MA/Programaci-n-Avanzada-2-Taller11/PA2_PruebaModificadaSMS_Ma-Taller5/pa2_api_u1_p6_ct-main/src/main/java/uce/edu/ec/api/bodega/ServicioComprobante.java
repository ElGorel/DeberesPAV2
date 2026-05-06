package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicioComprobante {

    public void generar(Pedido pedido) {
        System.out.println("--- Procesando Comprobante ---");
        
        // Lógica: si el email (destino) es nulo o vacío, es físico.
        if (pedido.getDestino() != null && !pedido.getDestino().isEmpty()) {
            System.out.println("[PDF] Enviando factura digital al correo: " + pedido.getDestino());
        } else {
            System.out.println("[FÍSICO] No hay destino registrado. Generando comprobante impreso...");
        }
    }
}

// opcion si no quiero hacer una intefaz 
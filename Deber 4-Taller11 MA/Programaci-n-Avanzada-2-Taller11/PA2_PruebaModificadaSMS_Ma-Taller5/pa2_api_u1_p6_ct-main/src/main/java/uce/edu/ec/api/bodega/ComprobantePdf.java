package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ComprobantePdf implements GeneradorComprobante {
    @Override
    public void procesar(Pedido pedido) {
        System.out.println("[SISTEMA PDF] Generando archivo digital para: " + pedido.getDestino());
    }
}

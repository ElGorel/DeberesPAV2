package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ComprobanteFisico implements GeneradorComprobante {
    @Override
    public void procesar(Pedido pedido) {
        System.out.println("[SISTEMA IMPRESIÓN] Generando ticket físico para el cliente.");
    }
}

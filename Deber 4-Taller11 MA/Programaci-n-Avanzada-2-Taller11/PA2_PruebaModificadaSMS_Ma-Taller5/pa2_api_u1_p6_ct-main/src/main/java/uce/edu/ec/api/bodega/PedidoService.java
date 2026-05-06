package uce.edu.ec.api.bodega;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@Unremovable
@ApplicationScoped 
public class PedidoService {

    @Inject
    private NotificadorSelector selector;

    // CORRECCIÓN: Inyectamos el Selector, no la Interfaz directamente
    @Inject
    private ComprobanteSelector comprobanteSelector;

    public void registrar(Pedido pedido, PagoEstrategia pago) {

        System.out.println("--- Iniciando Registro de Pedido ---");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Total: " + pedido.getTotal());
        
        // 1. Procesar el Pago
        pago.realizar(pedido.getTotal());

        // 2. Lógica de Comprobantes
        // El selector nos devuelve la implementación correcta (PDF o Físico)
        GeneradorComprobante comprobante = comprobanteSelector.seleccionar(pedido.getDestino());
        comprobante.procesar(pedido);

        // 3. Notificación
        Notificador notificador = this.selector.selecionar(pedido.getTotal());
        notificador.enviar(pedido.getDestino(), "Su pedido ha sido procesado");

        System.out.println("--- Pedido Finalizado ---");
    }
}
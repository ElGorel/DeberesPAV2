package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Pedido;
import ec.com.uce.domain.model.Pago;
import ec.com.uce.domain.model.Inventario;
import ec.com.uce.domain.model.Envio;
import ec.com.uce.domain.model.Notificacion;
import ec.com.uce.infrastructure.repository.PedidoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class PedidoService {

    @Inject
    private PedidoRepositoryImpl pedidoRepositoryImpl;

    @Inject
    private PagoService pagoService;

    @Inject
    private InventarioService inventarioService;

    @Inject
    private EnvioService envioService;

    @Inject
    private NotificacionService notificacionService;

    @MedirTiempo
    public void procesarPedido(Pedido pedido) {
        String nombrehilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo PedidoS  " + nombrehilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        // 1. Guardar el pedido
        this.pedidoRepositoryImpl.persist(pedido);

        // 2. Procesar el Pago (interno 1)
        Pago pago = new Pago();
        pago.setPedidoId(pedido.getId());
        pago.setMonto(pedido.getTotal());
        pago.setEstado("COMPLETADO");
        this.pagoService.procesarPago(pago);

        // 3. Reservar en Inventario (interno 2)
        Inventario inventario = new Inventario();
        inventario.setProducto("Articulo de Computacion");
        inventario.setCantidadReservada(1);
        this.inventarioService.actualizarInventario(inventario);

        // 4. Preparar el Envio (interno 3)
        Envio envio = new Envio();
        envio.setDireccion("Campus UCE, Quito");
        envio.setEmpresaTransporte("Servientrega");
        this.envioService.prepararEnvio(envio);

        // 5. Enviar Notificacion (interno 4)
        Notificacion notificacion = new Notificacion();
        notificacion.setDestinatario("estudiante@uce.edu.ec");
        notificacion.setMensaje("Su pedido ha sido procesado exitosamente.");
        this.notificacionService.enviarNotificacion(notificacion);
    }
}

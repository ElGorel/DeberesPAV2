package uce.edu.ec.api.bodega;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped // Siempre fuera de la clase
public class PedidoService1 {

    
    @Inject
    private NotificadorSelector selector;

    public void registrar(Pedido pedido) {

        System.out.println("Registrando pedido");
        System.out.println("cliente " + pedido.getCliente());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Guardando en la base de datos");

        // NotificadorMail nl = new NotificadorMail(); sin inyeccion

        // Con DI por el contenedor
        Notificador notificador = this.selector.selecionar(pedido.getTotal());
        notificador.enviar(null, null);

    }

}

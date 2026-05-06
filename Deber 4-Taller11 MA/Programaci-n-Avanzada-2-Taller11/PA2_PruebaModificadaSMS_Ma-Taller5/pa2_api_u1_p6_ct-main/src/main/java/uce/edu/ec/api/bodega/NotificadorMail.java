package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@ApplicationScoped
@Default // Esta anotacion dice que esta clase la va a gestionar un externo
public class NotificadorMail implements Notificador {

    public void enviar(String destino, String mensaje) {

        System.out.println("Se envia el mailal correo : " + destino);
        System.out.println("Con el mensaje: " + mensaje);

    }

}

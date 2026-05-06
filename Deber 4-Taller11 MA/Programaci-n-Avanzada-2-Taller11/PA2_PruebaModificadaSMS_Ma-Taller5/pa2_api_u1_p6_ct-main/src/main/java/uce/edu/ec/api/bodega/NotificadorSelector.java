package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class NotificadorSelector {

    @Inject
    private NotificadorMail mail;
    @Inject
    private NotificadorSms sms;
    @Inject
    private NotificadorWhatsApp wpp;

    public Notificador selecionar(double total) {

        if (total > 100) {
            // Caso 1: Mayor a 100
            return mail;
        } else if (total > 50) {
            // Caso 2: Entre 51 y 100 (inclusive)
            return sms;
        } else {
            // Caso 3: 50 o menos
            return wpp;
        }
    }

}

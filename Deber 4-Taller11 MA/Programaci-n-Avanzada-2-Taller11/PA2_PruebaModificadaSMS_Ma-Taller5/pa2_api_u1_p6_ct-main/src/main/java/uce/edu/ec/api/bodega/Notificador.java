package uce.edu.ec.api.bodega;

public interface Notificador {

    void enviar(String destino, String mensaje);
    
}

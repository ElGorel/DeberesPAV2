package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class ContadorServicio {
    
    private final AtomicInteger cuenta = new AtomicInteger(0);

    public int incrementar() {
        return cuenta.incrementAndGet();
    }
}
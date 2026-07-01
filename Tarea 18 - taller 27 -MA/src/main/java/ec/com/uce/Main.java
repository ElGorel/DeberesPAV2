package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.FacturaService;
import ec.com.uce.application.service.PedidoService;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Pedido;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String... args){
        Quarkus.run(App.class,args);
    }

    public static class App implements QuarkusApplication{
       
        @Inject
        private FacturaService facturaService;

        @Inject
        private PedidoService pedidoService;
       
        @Override
        public int run(String... args){
            // Registrar tiempo de inicio del método principal
            long tiempoInicioMain = System.currentTimeMillis();

            String nombrehilo = Thread.currentThread().getName();
            System.out.println("nombre del hilo main  " + nombrehilo);
            System.out.println("ID: "+ Thread.currentThread().threadId());

            System.out.println("--- EJECUTANDO TALLER 27 ---");
            
            Factura f2 = new Factura();
            f2.setFecha(LocalDate.of(2026, 11, 1));
            f2.setNumero("0001-006");
            f2.setRuc("1805245845001");

            this.facturaService.guardar(f2);

            System.out.println("\n--- EJECUTANDO DEBER (NUEVO EJEMPLO: PROCESAR PEDIDO) ---");
            
            Pedido p = new Pedido();
            p.setFecha(LocalDate.now());
            p.setClienteRuc("1790011223001");
            p.setTotal(350.50);

            this.pedidoService.procesarPedido(p);

            // Registrar tiempo de fin del método principal y calcular duración
            long tiempoFinMain = System.currentTimeMillis();
            long tiempoTotalMain = tiempoFinMain - tiempoInicioMain;
            System.out.println("\n>>> [CRONÓMETRO MAIN] El método principal tardó " + tiempoTotalMain + " ms.");

            return 0;
        }
    }
}


package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.CuentaBancariaService;
import ec.edu.uce.application.service.TranferenciaService;
import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.Transferencia;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        CuentaBancariaService cuentaBancariaService;
        @Inject
        TranferenciaService tranferenciaService;
        

        @Inject
        EntityManager em;

        @Override
        public int run(String... args) {


            CuentaBancaria b1 = new CuentaBancaria();
            b1.setNumeroCuenta("2204299007");
            b1.setSaldo(500.00);
            b1.setTitular("Marco Andrade");

            CuentaBancaria b2 = new CuentaBancaria();
            b2.setNumeroCuenta("2204299008");
            b2.setSaldo(100.00);
            b2.setTitular("Jorge Carrera");

            cuentaBancariaService.registrarCuenta(b1);
            cuentaBancariaService.registrarCuenta(b2);

            Transferencia t1 = new Transferencia();
            t1.setCuentaOrigen(b1);
            t1.setCuentaDestino(b2);
            t1.setMonto(200.0);
            t1.setFecha(LocalDateTime.of(2026, 06, 22, 18, 30));

            tranferenciaService.realizarTransferencia(t1);




















            return 0;
        }
    }
}

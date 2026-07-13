package ec.com.uce.application.service;

import org.eclipse.microprofile.context.ManagedExecutor;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infrastructure.repository.FacturaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class FacturaServiceParalelo {

    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;

    @Inject
    private MailService mailService; // Inyectamos aquí para mantener el Proxy del interceptor

    @Inject
    private ReporteServiceTarea reporteServiceT; // Asegúrate de tener este servicio inyectado

    @Inject
    private ManagedExecutor managedExecutor; // El pool de hilos administrado por Quarkus

    // Excecutor service es el uso manual de hilos por el usuario
    // a Diferencia el managedExcecutor otroga el control a Quakus sobre los hilos


    @MedirTiempo
    public void guardar(Factura factura) {
        
        String nombrehiloFacturaS = Thread.currentThread().getName();
        System.out.println("nombre del hilo FacturaS: " + nombrehiloFacturaS + " (ID: " + Thread.currentThread().threadId() + ")");
        
        // 1. Guardar factura en el hilo principal
        this.facturaRepositoryImpl.persist(factura);

        // 2. Ejecutar Reporte en un hilo del pool de Quarkus
        Reporte repo = new Reporte();
        this.reporteServiceT.setReporte(repo); // ejemplo de como manejar la inyeccion sin pasar por constructor
         
        //Future<?> futureR = managedExecutor.submit(reporteTarea);
        managedExecutor.submit(reporteServiceT);

        // 3. Ejecutar Mail en otro hilo del pool de Quarkus
        Mail mail = new Mail();
        MailServiceTarea mailtTarea = new MailServiceTarea(mail,mailService); // ejemplo de como manejamos la inyeccion pasando por contruccion
        //Future<?> futureM =managedExecutor.submit(mailtTarea);
        managedExecutor.submit(mailtTarea);

        //futureM.get();
        //futureR.get();


    }
}
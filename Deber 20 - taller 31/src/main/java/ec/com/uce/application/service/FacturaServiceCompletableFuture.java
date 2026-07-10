package ec.com.uce.application.service;

import java.util.concurrent.CompletableFuture;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infrastructure.repository.FacturaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class FacturaServiceCompletableFuture {

    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;

    @Inject
    private ReporteService reporteService;
    @Inject
    private MailService mailService;


    @MedirTiempo
    public void guardar(Factura factura){
        
        String nombrehiloFacturaS = Thread.currentThread().getName();
        System.out.println("nombre del hilo FacturaS  " + nombrehiloFacturaS);
        System.out.println("ID: "+ Thread.currentThread().threadId());


        this.facturaRepositoryImpl.persist(factura);
        
        Reporte repo = new Reporte();

        // en esta sentencia decimos que esta tarea se ejecute de manera asyncrona
        CompletableFuture<Void> completableReporte = CompletableFuture.runAsync(()->this.reporteService.guardarReporte(repo));


        Mail mail = new Mail();

        CompletableFuture<Void> completableMail = CompletableFuture.runAsync(()->this.mailService.guardarMail(mail));

        // aqui le decimos cuales son las tareas que vamos a esperar que se completen
        CompletableFuture.allOf(completableMail,completableReporte).join();

    }



    public Factura buscarPorId(Integer id){

        return Factura.findById(id);
        //return this.facturaRepositoryImpl.findById(id);
    }



}


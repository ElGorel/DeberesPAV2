package ec.com.uce.application.service;

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
public class FacturaService {

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

        this.reporteService.guardarReporte(repo);


        Mail mail = new Mail();

        this.mailService.guardarMail(mail);


    }



    public Factura buscarPorId(Integer id){

        return Factura.findById(id);
        //return this.facturaRepositoryImpl.findById(id);
    }



}

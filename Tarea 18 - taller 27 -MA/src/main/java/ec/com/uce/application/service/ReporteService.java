package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Reporte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteService {

    @MedirTiempo
     public void guardarReporte(Reporte reporte){
        
        String nombrehiloreporteS = Thread.currentThread().getName();

            System.out.println("nombre del hilo reporteS  " + nombrehiloreporteS);
        System.out.println("ID: "+ Thread.currentThread().threadId());
        reporte.persist();
    }



}

package ec.com.uce.application.service;

import java.util.List;

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
        
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        
       
       
        reporte.persist();
    }


    @MedirTiempo
    public void guardarListaReportes(List<Reporte> lista){

        for(Reporte p : lista){
            this.guardarReporte(p);
        }



    }

}

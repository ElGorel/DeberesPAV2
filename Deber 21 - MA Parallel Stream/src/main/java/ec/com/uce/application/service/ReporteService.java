package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.application.service.interceptors.MedirTiempo;
import ec.com.uce.domain.model.Reporte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteService {

    public void guardarReporte(Reporte reporte){
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo Reporte: " + nombreHilo);
        System.out.println("ID:" + Thread.currentThread().threadId());
        
        /* try {
            Thread.sleep(1000); 
        } catch(Exception e) {
            e.printStackTrace();
        }
         */
        reporte.persist();
    }

    @MedirTiempo
    public void guardarListaReportes(List<Reporte> lista){
        for(Reporte p : lista){
            this.guardarReporte(p);
        }
    }

    @MedirTiempo
    public void guardarListaReportesParalelo(List<Reporte> lista){
        lista.parallelStream().forEach(repote -> {
            //aqui programo toda la logica que quiero que se aplique a cada item de la lista
            this.guardarReporte(repote);
        });
    }

    public Reporte buscarReporteporId(Integer id){
        return Reporte.findById(id);
    }
}
package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.Infraestructure.repository.ReporteRepositoryImpl;
import ec.com.uce.domain.model.Reporte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    public List<Reporte> buscartodos(){
        return (List<Reporte>) this.reporteRepositoryImpl.findAll();
    }


    public Reporte buscarporId(Integer id){
        return (Reporte) this.reporteRepositoryImpl.findById(id);
    }

    public void guardar (Reporte reporte){
        this.reporteRepositoryImpl.persist(reporte);
    }

    public void eliminar ( Integer id ){
        this.reporteRepositoryImpl.delete(this.buscarporId(id));
    }

    public void actualizar (Reporte reporteactualizado,Integer id){
        Reporte reporteBase=this.buscarporId(id);
        reporteBase.setNombre(reporteactualizado.getNombre());
        reporteBase.setTexto(reporteactualizado.getTexto());
        // no hace falta realizar explicitamente un update, se sincroniza con la base automaticamente
    }

    public void actualizar2 (Reporte reporte,Integer id){
        Reporte reporteBase=this.buscarporId(id);
    }


}
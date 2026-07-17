package ec.com.uce.Infraestructure.repository;


import ec.com.uce.domain.model.Reporte;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ReporteRepositoryImpl implements PanacheRepositoryBase<Reporte, Integer>{

    public Reporte buscarPorNumero(String numero){
        
        
        return null;
    }
    

}

package ec.com.uce.web.resource;

import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;



@Path("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService reporteService;

    public Reporte buscarPorId(Integer id){
        return this.reporteService.buscarporId(id);
    }



}

package ec.com.uce.application.service;

import ec.com.uce.domain.model.Reporte;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ReporteServiceTarea implements Runnable{

    
    private ReporteService reporteService;

    private Reporte Reporte;


    






    @Override
    public void run() {
        System.out.println("guardando reporte desde el hilo: " + Thread.currentThread().getName());
        this.reporteService.guardarReporte(this.Reporte);
    }


    
    public Reporte getReporte() {
        return Reporte;
    }

    public void setReporte(Reporte Reporte) {
        this.Reporte = Reporte;
    }

}

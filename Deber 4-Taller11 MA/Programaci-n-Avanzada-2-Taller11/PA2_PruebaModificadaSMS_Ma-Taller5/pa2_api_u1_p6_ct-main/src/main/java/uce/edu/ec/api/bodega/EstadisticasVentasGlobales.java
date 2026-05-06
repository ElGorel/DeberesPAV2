package uce.edu.ec.api.bodega;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadisticasVentasGlobales {

    private int  totalVentas=0;
    private double montoTotalVendido;

    public void registrarVenta(double totalVentaIndividual){
        
        this.totalVentas++;
        this.montoTotalVendido += totalVentaIndividual;



    }

    public void mostrarEstadisticasGlobales (){
        System.out.println("ESTADISTICAS GLOBALES");
        System.out.println("Cantidad de ventas: " + this.totalVentas);
        System.out.println("Valor total vendido " + this.montoTotalVendido);
    }

}

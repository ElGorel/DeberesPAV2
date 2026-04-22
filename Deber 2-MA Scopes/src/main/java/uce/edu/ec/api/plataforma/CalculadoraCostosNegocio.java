package uce.edu.ec.api.plataforma;

import jakarta.enterprise.context.Dependent;

// SERVICIO DE NEGOCIO QUE CAMBIA EN CADA LUGAR DONDE SE NECESITA
@Dependent
public class CalculadoraCostosNegocio {
    private double costoAcumulado = 0.0;

    public double agregarServicioAdicional(double precio) {
        // Lógica de negocio temporal: suma costos solo para la transacción actual
        costoAcumulado += precio;
        return costoAcumulado;
    }
}
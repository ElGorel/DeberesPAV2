package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.CuentaBancaria;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface CuentaBancariaRepository {


    public void insertar (CuentaBancaria cuentaBancaria);

    public CuentaBancaria consultar (String numero);

    public void actualizar(CuentaBancaria cuentaBancaria);


}

package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaService {

    @Inject
    CuentaBancariaRepository cuentaBancariaRepository;

     public void registrarCuenta(CuentaBancaria cuentaBancaria) {
        System.out.println("Guardando Cuenta de: " + cuentaBancaria.getTitular());
        this.cuentaBancariaRepository.insertar(cuentaBancaria);
    }

    public CuentaBancaria consultarCuenta(String numero) {
        System.out.println("consutltando : " + numero);
        CuentaBancaria cuenta = this.cuentaBancariaRepository.consultar(numero);
        return cuenta;
    }

}

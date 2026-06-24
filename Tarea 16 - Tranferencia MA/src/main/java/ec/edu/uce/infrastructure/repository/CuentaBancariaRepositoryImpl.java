package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repository.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository{

    @Inject 
    private EntityManager em;


    @Override
    public void insertar(CuentaBancaria cuentaBancaria) {
        this.em.persist(cuentaBancaria);
    }

    @Override
public CuentaBancaria consultar(String numero) {
    try {
        return this.em.createQuery(
            "SELECT c FROM CuentaBancaria c WHERE c.numeroCuenta = :numero", 
            CuentaBancaria.class
        )
        .setParameter("numero", numero)
        .getSingleResult();
    } catch (jakarta.persistence.NoResultException e) {
        // Si no encuentra la cuenta, retorna null para que lo manejes en tu servicio
        return null; 
    }
}

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.em.merge(cuentaBancaria);
    }

}

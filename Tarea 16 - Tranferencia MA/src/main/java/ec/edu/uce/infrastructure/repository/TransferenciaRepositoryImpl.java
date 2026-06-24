package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.TranferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class TransferenciaRepositoryImpl implements TranferenciaRepository{

    @Inject 
    private EntityManager em;


    @Override
    public void realizarTranferencia(Transferencia transferencia) {
        this.em.persist(transferencia);
    }

    @Override
    public Transferencia consultar(Integer id) {
        return this.em.find(Transferencia.class, id);
    }

}

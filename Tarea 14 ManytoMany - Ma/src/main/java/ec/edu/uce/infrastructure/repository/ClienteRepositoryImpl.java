package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.repository.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class ClienteRepositoryImpl implements ClienteRepository{


    @Inject 
    private EntityManager em;



    @Override
    public void insertar(Cliente cliente) {
       this.em.persist(cliente); 
    }
    
    
    

}

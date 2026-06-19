package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Autor;
import ec.edu.uce.domain.repository.AutorRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

public class AutorRepositoryImpl implements AutorRepository {

    @Inject 
    private EntityManager em;

    @Override
    public void insertar(Autor autor) {
        this.em.persist(autor);
    }

    

    

}

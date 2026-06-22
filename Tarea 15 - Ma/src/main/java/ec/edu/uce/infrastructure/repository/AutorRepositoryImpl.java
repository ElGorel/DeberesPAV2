package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Autor;
import ec.edu.uce.domain.repository.AutorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class AutorRepositoryImpl implements AutorRepository {

    @Inject 
    private EntityManager em;

    @Override
    public void insertar(Autor autor) {
        this.em.persist(autor);
    }

    @Override
    public Autor consultar(Integer id) {
        return this.em.find(Autor.class, id);
    }

    

    

}

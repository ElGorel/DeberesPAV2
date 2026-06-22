package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Pelicula;
import ec.edu.uce.domain.repository.PeliculaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PeliculaRepositoryImpl implements PeliculaRepository {

    @Inject 
    private EntityManager em;

    @Override
    public void insertar(Pelicula pelicula) {
        this.em.persist(pelicula);
    }

    @Override
    public Pelicula consultar(Integer id) {
        return this.em.find(Pelicula.class, id);
    }
}

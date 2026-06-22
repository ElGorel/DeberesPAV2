package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Actor;
import ec.edu.uce.domain.repository.ActorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ActorRepositoryImpl implements ActorRepository {

    @Inject 
    private EntityManager em;

    @Override
    public void insertar(Actor actor) {
        this.em.persist(actor);
    }

    @Override
    public Actor consultar(Integer id) {
        return this.em.find(Actor.class, id);
    }
}

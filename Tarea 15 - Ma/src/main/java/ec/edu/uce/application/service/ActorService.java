package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Actor;
import ec.edu.uce.domain.repository.ActorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ActorService {

    @Inject
    private ActorRepository actorRepository;

    public void registrarActor(Actor actor) {
        System.out.println("Guardando Actor: " + actor.getNombre());
        this.actorRepository.insertar(actor);
    }

    public Actor consultarActor(Integer id) {
        System.out.println("Consultando Actor: " + id);
        return this.actorRepository.consultar(id);
    }
}

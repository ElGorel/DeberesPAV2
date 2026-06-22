package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Actor;

public interface ActorRepository {
    void insertar(Actor actor);
    Actor consultar(Integer id);
}

package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class AlumnoRepositoryImpl implements AlumnoRepository{

    @Inject 
    private EntityManager em;

    @Override
    public void insertar(Alumno alumno) {
        this.em.persist(alumno);
    }

    @Override
    public Alumno consultar(Integer id) {
        return this.em.find(Alumno.class, id);
    }

}
